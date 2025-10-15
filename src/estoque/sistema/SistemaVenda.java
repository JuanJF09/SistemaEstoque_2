package estoque.sistema;

import estoque.dao.VendaDAO;
import estoque.model.Venda;
import java.util.List;

public class SistemaVenda {

    public Venda criarVenda(String produto, int quantidade, double precoUnitario) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        if (precoUnitario <= 0) throw new IllegalArgumentException("Preço unitário deve ser maior que zero.");

        Venda v = new Venda();
        v.setProduto(produto);
        v.setQuantidade(quantidade);
        v.setPrecoUnitario(precoUnitario);
        v.setPrecoTotal(quantidade * precoUnitario);

        VendaDAO.adicionar(v);
        return v;
    }

    public List<Venda> listarVendas() {
        return VendaDAO.listar();
    }

    public boolean removerVenda(int id) {
        return VendaDAO.remover(id);
    }

    public Venda buscarVenda(int id) {
        return VendaDAO.buscarPorId(id);
    }

    public boolean atualizarVenda(int id, String novoProduto, int novaQuantidade, double novoPrecoUnitario) {
        Venda v = VendaDAO.buscarPorId(id);
        if (v == null) return false;

        v.setProduto(novoProduto);
        v.setQuantidade(novaQuantidade);
        v.setPrecoUnitario(novoPrecoUnitario);
        v.setPrecoTotal(novaQuantidade * novoPrecoUnitario);

        return VendaDAO.atualizar(v);
    }

    public double calcularTotalGeral() {
        return VendaDAO.listar().stream()
                .mapToDouble(Venda::getPrecoTotal)
                .sum();
    }
}

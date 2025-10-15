package estoque.dao;

import estoque.model.Venda;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private static List<Venda> vendas = new ArrayList<>();
    private static int contadorId = 1;

    public static void adicionar(Venda venda) {
        venda.setId(contadorId++);
        vendas.add(venda);
    }

    public static List<Venda> listar() {
        return vendas;
    }

    public static boolean remover(int id) {
        return vendas.removeIf(v -> v.getId() == id);
    }

    public static Venda buscarPorId(int id) {
        for (Venda v : vendas) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public static boolean atualizar(Venda vendaAtualizada) {
        for (int i = 0; i < vendas.size(); i++) {
            if (vendas.get(i).getId() == vendaAtualizada.getId()) {
                vendas.set(i, vendaAtualizada);
                return true;
            }
        }
        return false;
    }
}

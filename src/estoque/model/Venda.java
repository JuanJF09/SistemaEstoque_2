/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque.model;

public class Venda {
    private int id;
    private String produto;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }

    public double getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(double precoTotal) { this.precoTotal = precoTotal; }

    @Override
    public String toString() {
        return "Venda [ID=" + id + 
               ", Produto=" + produto + 
               ", Quantidade=" + quantidade +
               ", Unitário=R$" + precoUnitario +
               ", Total=R$" + precoTotal + "]";
    }
}



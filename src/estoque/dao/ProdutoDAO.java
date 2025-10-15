/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque.dao;

/* Classe responsável por gerenciar os dados dos produtos.
 de novo nada demais um simples codigo*/


import estoque.model.Produto;   // Importa a classe Produto
import java.util.ArrayList;     // Lista dinâmica para armazenar produtos
import java.util.List;          // Interface de lista genérica


public class ProdutoDAO {
    // Lista estática que armazena todos os produtos cadastrados em memória
    private static List<Produto> listaProduto = new ArrayList<>();
    private static int idCounter = 1;

    // --- Método para adicionar um novo produto ---
    public static void adicionar(Produto p) {
        listaProduto.add(p);
    }

    public static List<Produto> listar() {
        return listaProduto;  // Retorna a lista completa
    }

    public static int gerarId() {
        return idCounter++;
    }
}
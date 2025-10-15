/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package estoque.controller;

import estoque.model.Produto;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListaProdutoController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtPrecoCusto;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtMaterial;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtDescricao;
    
    @FXML
    private TableView<Produto> tabelaProdutos;
    
    @FXML
    private TableColumn<Produto, Integer> colId;
    @FXML
    private TableColumn<Produto, String> colNome;
    @FXML
    private TableColumn<Produto, Integer> colQuantidade;
    @FXML
    private TableColumn<Produto, Double> colPrecoCusto;
    @FXML
    private TableColumn<Produto, Double> colPreco;
    @FXML
    private TableColumn<Produto, String> colMaterial;
    @FXML
    private TableColumn<Produto, String> colCategoria;
    @FXML
    private TableColumn<Produto, String> colDescricao;

    private final ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPrecoCusto.setCellValueFactory(new PropertyValueFactory<>("precoCusto"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        tabelaProdutos.setItems(listaProdutos);

        carregarProdutosDoArquivo();
    }

    @FXML
    private void abrirCadastro(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/estoque/view/CadastroProduto.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastro de Produto");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void salvarProduto() {
        String caminhoArquivo = "produtos.txt";

        if (txtNome.getText().isEmpty() || txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos obrigatórios!", AlertType.ERROR);
            return;
        }

        try {
       
            int novoId = listaProdutos.size() + 1;
            String nome = txtNome.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            double precoCusto = Double.parseDouble(txtPrecoCusto.getText().replace(",", "."));
            double preco = Double.parseDouble(txtPreco.getText().replace(",", "."));
            String material = txtMaterial.getText();
            String categoria = txtCategoria.getText();
            String descricao = txtDescricao.getText();

            if (preco <= 0 || precoCusto < 0 || quantidade < 0) {
                mostrarAlerta("Erro", "Valores inválidos!", AlertType.WARNING);
                return;
            }

            // Cria o produto com ID
            Produto novoProduto = new Produto(novoId, nome, quantidade, precoCusto, preco, material, categoria, descricao);
            listaProdutos.add(novoProduto);

            // Salva no arquivo com ID
            try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {
                writer.write(novoId + ";" + nome + ";" + quantidade + ";" + precoCusto + ";" + preco + ";" + material + ";" + categoria + ";" + descricao + "\n");
            }

            mostrarAlerta("Sucesso", "Produto salvo com sucesso!", AlertType.INFORMATION);
            limparCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Preço ou quantidade inválidos!", AlertType.ERROR);
        } catch (IOException e) {
            mostrarAlerta("Erro", "Não foi possível salvar o produto.", AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void carregarProdutosDoArquivo() {
        String caminhoArquivo = "produtos.txt";
        listaProdutos.clear();

        try (Scanner scanner = new Scanner(new java.io.File(caminhoArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");

                if (dados.length == 8) { // Agora inclui o ID
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[2]);
                    double precoCusto = Double.parseDouble(dados[3]);
                    double preco = Double.parseDouble(dados[4]);
                    String material = dados[5];
                    String categoria = dados[6];
                    String descricao = dados[7];

                    Produto produto = new Produto(id, nome, quantidade, precoCusto, preco, material, categoria, descricao);
                    listaProdutos.add(produto);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo produtos.txt não encontrado.");
        }
    }
    
    @FXML
    private void voltar(ActionEvent event)throws IOException{
        Parent telaAnterior =FXMLLoader.load(getClass().getResource("/estoque/view/TelaInicial.fxml"));
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
       stage.setScene(new Scene(telaAnterior));
        stage.show();
    
    }

    private void mostrarAlerta(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtId.clear();
        txtNome.clear();
        txtQuantidade.clear();
        txtPrecoCusto.clear();
        txtPreco.clear();
        txtMaterial.clear();
        txtCategoria.clear();
        txtDescricao.clear();
    }
}

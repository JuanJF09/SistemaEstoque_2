package estoque.controller;

import estoque.model.Venda;
import estoque.sistema.SistemaVenda;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class VendaController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtProduto;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtPrecoUnitario;
    @FXML
    private TextField txtPrecoTotal;

    @FXML
    private TableView<Venda> tabelaVendas;
    @FXML
    private TableColumn<Venda, Integer> colId;
    @FXML
    private TableColumn<Venda, String> colProduto;
    @FXML
    private TableColumn<Venda, Integer> colQuantidade;
    @FXML
    private TableColumn<Venda, Double> colPrecoUnitario;
    @FXML
    private TableColumn<Venda, Double> colPrecoTotal;

    private SistemaVenda sistemaVenda = new SistemaVenda();
    private ObservableList<Venda> listaObservable;

    @FXML
    public void initialize() {
        // Configura as colunas da tabela
        colId.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getId()).asObject());
        colProduto.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getProduto()));
        colQuantidade.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getQuantidade()).asObject());
        colPrecoUnitario.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrecoUnitario()).asObject());
        colPrecoTotal.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrecoTotal()).asObject());

        atualizarTabela();
    }

    private void atualizarTabela() {
        listaObservable = FXCollections.observableArrayList(sistemaVenda.listarVendas());
        tabelaVendas.setItems(listaObservable);
    }

    @FXML
    private void calcularTotal() {
        try {
            int qtd = Integer.parseInt(txtQuantidade.getText());
            double preco = Double.parseDouble(txtPrecoUnitario.getText());
            txtPrecoTotal.setText(String.valueOf(qtd * preco));
        } catch (NumberFormatException e) {
            txtPrecoTotal.setText("Erro");
        }
    }

    @FXML
    private void salvarVenda() {
        try {
            String produto = txtProduto.getText();
            int qtd = Integer.parseInt(txtQuantidade.getText());
            double preco = Double.parseDouble(txtPrecoUnitario.getText());

            sistemaVenda.criarVenda(produto, qtd, preco);
            atualizarTabela();
            limparCampos();
        } catch (Exception e) {
            mostrarAlerta("Erro ao salvar venda: " + e.getMessage());
        }
    }

    @FXML
    private void alterarVenda() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String produto = txtProduto.getText();
            int qtd = Integer.parseInt(txtQuantidade.getText());
            double preco = Double.parseDouble(txtPrecoUnitario.getText());

            boolean ok = sistemaVenda.atualizarVenda(id, produto, qtd, preco);
            if (ok) {
                mostrarAlerta("Venda " + id + " atualizada!");
                atualizarTabela();
                limparCampos();
            } else {
                mostrarAlerta("Venda não encontrada!");
            }
        } catch (Exception e) {
            mostrarAlerta("Erro ao alterar: " + e.getMessage());
        }
    }

    @FXML
    private void removerVenda() {
        try {
            Venda selecionada = tabelaVendas.getSelectionModel().getSelectedItem();
            if (selecionada != null) {
                sistemaVenda.removerVenda(selecionada.getId());
                atualizarTabela();
            } else {
                mostrarAlerta("Selecione uma venda para remover.");
            }
        } catch (Exception e) {
            mostrarAlerta("Erro ao remover: " + e.getMessage());
        }
    }

    @FXML
    private void carregarVendaSelecionada() {
        Venda v = tabelaVendas.getSelectionModel().getSelectedItem();
        if (v != null) {
            txtId.setText(String.valueOf(v.getId()));
            txtProduto.setText(v.getProduto());
            txtQuantidade.setText(String.valueOf(v.getQuantidade()));
            txtPrecoUnitario.setText(String.valueOf(v.getPrecoUnitario()));
            txtPrecoTotal.setText(String.valueOf(v.getPrecoTotal()));
        }
    }

    @FXML
    private void voltar(javafx.event.ActionEvent event) throws IOException {
        Parent telaAnterior = FXMLLoader.load(getClass().getResource("/estoque/view/TelaInicial.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(telaAnterior));
        stage.show();
    }
    
    

    private void limparCampos() {
        txtId.clear();
        txtProduto.clear();
        txtQuantidade.clear();
        txtPrecoUnitario.clear();
        txtPrecoTotal.clear();
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

package estoque.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TelaInicialController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void Cadastrar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/estoque/view/ListaProduto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Alterar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/estoque/view/Alterar.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Excluir(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/estoque/view/Excluir.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Venda(ActionEvent event) throws IOException {
    System.out.println("Botão Venda clicado!");
    root = FXMLLoader.load(getClass().getResource("/estoque/view/Venda.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

}

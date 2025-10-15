/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;

public class AlterarController {

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
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // Botão Voltar
    @FXML
    private void Voltar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/estoque/view/TelaInicial.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
   
    
    private void alterar(ActionEvent event){
        
        
    }
}

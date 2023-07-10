/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author gayan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button closeButton;

    //DATABASE TOOLS
    private Connection connection;
    private java.sql.PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private PreparedStatement PreparedStatement;

    public void loginAdmin(){

        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        connection = dbConnection.con();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userNameTextField.getText());
            preparedStatement.setString(2,passwordTextField.getText());
            resultSet = preparedStatement.executeQuery();
            Alert alert;

            if(userNameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                if(resultSet.next()){

                    getData.username = userNameTextField.getText();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login !");
                    alert.showAndWait();

                    loginButton.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();

                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username and Password");
                    alert.showAndWait();
                }
            }

        }catch (Exception e){ e.printStackTrace();}


    }

    public void closeButton(){
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

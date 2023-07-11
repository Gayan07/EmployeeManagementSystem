package employeemanagementsystem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button closeButton;

    @FXML
    private Label userNameTextField;

    @FXML
    private Button homeButton;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button salaryButton;

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane homeForm;

    @FXML
    private Label homeTotalEmployeeLabel;

    @FXML
    private Label homeTotalPresentsLabel;

    @FXML
    private Label homeTotalInactiveEmployee;

    @FXML
    private BarChart<?, ?> homeChartView;

    @FXML
    private AnchorPane addEmployeeForm;

    @FXML
    private TableView<?> addEmployeeTableView;

    @FXML
    private TableColumn<?, ?> addEmployeeColEmployeeID;

    @FXML
    private TableColumn<?, ?> addEmployeeColFirstName;

    @FXML
    private TableColumn<?, ?> addEmployeeColLastName;

    @FXML
    private TableColumn<?, ?> addEmployeeColGender;

    @FXML
    private TableColumn<?, ?> addEmployeeColEducation;

    @FXML
    private TableColumn<?, ?> addEmployeeColPhone;

    @FXML
    private TableColumn<?, ?> addEmployeeColPosition;

    @FXML
    private TableColumn<?, ?> addEmployeeColDateMember;

    @FXML
    private TextField employeeSearchTextField;

    @FXML
    private TextField addEmployeeEmployeeIDTextField;

    @FXML
    private TextField addEmployeeFirstNameTextField;

    @FXML
    private TextField addEmployeeLastNameTextField;

    @FXML
    private ComboBox<?> addEmployeeGenderComboBox;

    @FXML
    private TextField addEmployeePhoneNumberTextField;

    @FXML
    private ComboBox<?> addEmployeePositionComboBox;

    @FXML
    private ImageView  addEmployeeImageView;

    @FXML
    private Button addEmployeeImportButton;

    @FXML
    private Button addEmployeeAddButton;

    @FXML
    private Button addEmployeeUpdateButton;

    @FXML
    private Button addEmployeeDeleteButton;

    @FXML
    private Button addEmployeeClearButton;

    @FXML
    private AnchorPane salaryForm;

    @FXML
    private TextField salaryEmployeeIDTextField;

    @FXML
    private Label salaryFirstNameLabel;

    @FXML
    private Label salaryLastNameLabel;

    @FXML
    private Label salaryPositionLabel;

    @FXML
    private TextField salarySalaryTextField;

    @FXML
    private Button salaryClearButton;

    @FXML
    private Button salaryUpdateButton;

    @FXML
    private TableView<?> salaryTableView;

    @FXML
    private TableColumn<?, ?> salaryColEmployeeID;

    @FXML
    private TableColumn<?, ?> salaryColFirstName;

    @FXML
    private TableColumn<?, ?> salaryColLastName;

    @FXML
    private TableColumn<?, ?> salaryColPosition;

    @FXML
    private TableColumn<?, ?> salaryColSalary;

    private Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public ObservableList<employeeData> addEmployeeListData(){
        String sql = "SELECT * FROM employee";

        connect = database.connectDb();

        try{
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            employeeData employeeData;

            while(resultSet.next()){
                employeeData = new employeeData( resultSet.getInt("employee_id") ,resultSet.getString("firstname"), resultSet.getString("lastName"), resultSet.getString("gender"), resultSet.getString("phoneNum") , resultSet.getString("position") , resultSet.getString("image"), resultSet.getDate("Date"));
            }

        }catch (Exception e) {e.printStackTrace();}
        return null;
    }
    public void displayUserName(){
        userNameTextField.setText(getData.username);
    }
     public void switchForm(ActionEvent event){

         if(event.getSource() == homeButton){
             homeForm.setVisible(true);
             addEmployeeForm.setVisible(false);
             salaryForm.setVisible(false);

             homeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #00b6ff, #28966c)");
             addEmployeeButton.setStyle("-fx-background-color: transparent");
             salaryButton.setStyle("-fx-background-color: transparent");

         }else if (event.getSource() == addEmployeeButton){
             homeForm.setVisible(false);
             addEmployeeForm.setVisible(true);
             salaryForm.setVisible(false);

             homeButton.setStyle("-fx-background-color: transparent");
             addEmployeeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #00b6ff, #28966c)");
             salaryButton.setStyle("-fx-background-color: transparent");

         }else if (event.getSource() == salaryButton){
             homeForm.setVisible(false);
             addEmployeeForm.setVisible(false);
             salaryForm.setVisible(true);

             homeButton.setStyle("-fx-background-color: transparent");
             addEmployeeButton.setStyle("-fx-background-color: transparent");
             salaryButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #00b6ff, #28966c)");
         }

     }
    public void logout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout ?");
        Optional<ButtonType> option = alert.showAndWait();

        try{
            if(option.get().equals(ButtonType.OK)){

                logoutButton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene =new Scene(root);

                stage.setScene(scene);
                stage.show();

            }
        }catch (Exception e){ e.printStackTrace();{

        }
    }
    }

    public void close(){
        System.exit(0);
    }

    public void minimize(){
        Stage stage = (Stage)mainForm.getScene().getWindow();
        stage.setIconified(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


package employeemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
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
    private ImageView addEmployeeImageView;

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


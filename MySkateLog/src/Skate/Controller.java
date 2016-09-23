package Skate;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by rubinkazan on 22/09/2016.
 */
public class Controller implements Initializable{

    @FXML
    private Button btnSubmit;
    @FXML
    private Label lblWelcome;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField txfTime;
    @FXML
    private ComboBox cmbTricks;
    @FXML
    private ComboBox cmbSets;
    @FXML
    private ComboBox cmbReps;
    @FXML
    private ComboBox cmbLanded;
    @FXML
    private RadioButton rbTraining;
    @FXML
    private RadioButton rbCasual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }

    private void exit(){
        btnSubmit = new Button();
        btnSubmit.setOnAction(event -> System.exit(0));
    }


    public static void main(String[] args) {

    }


}

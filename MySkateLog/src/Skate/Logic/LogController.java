package Skate.Logic;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.*;

public class LogController {
    @FXML
    private TableView<TableLog> skateTable;
    //@FXML
    //private TabPane<TableLog> skatePane;
    @FXML
    private TableColumn<TableLog, String> dateCol;
    @FXML
    private TableColumn<TableLog, String> timeCol;
    @FXML
    private TableColumn<TableLog, String> sessionCol;
    @FXML
    private TableColumn<TableLog, String> trickCol;
    @FXML
    private TableColumn<TableLog, Double> successCol;

    private MainX mainX;

    public LogController(){

    }

    @FXML
    private void initialize(){
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        timeCol.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        sessionCol.setCellValueFactory(cellData -> cellData.getValue().sessionTypeProperty());
        trickCol.setCellValueFactory(cellData -> cellData.getValue().trickNameProperty());
        successCol.setCellValueFactory(cellData -> cellData.getValue().successRateProperty().asObject());

    }

    public void setMainX(MainX mainX){
        this.mainX = mainX;

        skateTable.setItems(mainX.getLogData());
    }


}

package Skate;
//RE_making Gui

//Graph done 15/9/16 11:15am
//Table done 15/9/16 1:01pm
//TODO TABLE and 'TODAY' Panel
//TODO Followed by GUI functionality
//TODO Followed by SQL
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainX extends Application {
    private double dragOffsetX;
    private Stage stage;
    private double dragOffsetY;

    //GUI Components
    //850*600//W*H
    TabPane tabPane;
    Tab tabToday;
    Tab tabLog;
    Tab tabProgress;
    //120*18//W*H
    Label lblSkateArea;
    Label lblWelcome;
    Label lblQuestion;
    Label lblDate;
    Label lblTime;
    Label lblTrickPeformed;
    //120*20//W*H
    RadioButton rbCasual;
    RadioButton rbTraining;
    //200*30//W*H
    DatePicker datePicker;
    //225*30//W*H
    ComboBox trickPerformed;
    //50*30//W*H
    ComboBox cmbTrickPerformed;
    ComboBox cmbSets;
    ComboBox cmbReps;
    ComboBox cmbTotalLanded;
    //60*30//W*H
    Button btnSubmit;
    Button btnExit;
    Button btnMin;
    //200*30//W*H
    TextField txfTime;
    //10*500//W*H
    Separator sepVertical;


    //Chart
    private TableView<Entry> logTable = new TableView<Entry>();
    private final ObservableList<Entry>data =
            FXCollections.observableArrayList(
                    new Entry("12/08/2016", "30:00", "Training", "Ollie", "40%"),
                    new Entry("13/08/2016", "30:00", "Training", "Ollie", "45%"),
                    new Entry("14/08/2016", "", "Casual", "", ""),
                    new Entry("15/08/2016", "30:00", "Training", "FS 180", "30%")
                    );

    @Override
    public void start(Stage stage){
        //Dummy values
        int d1 = 1, d2 = 2, d3 = 3, d4 = 4, d5 = 5, d6 = 6, d7 = 7, d8 = 8,
                d9 = 9, d10 = 10;
        this.stage = stage;
        Group root = new Group();
        Scene scene = new Scene(root, 850, 600);
        BorderPane mainPane = new BorderPane();

        //Creating Tabs of LSD25
        //Today
        tabToday = new Tab();
        tabToday.setText("Today");
        lblSkateArea = new Label("Skate Area");
        //GMaps widget
        //Welcome, -username-
        lblWelcome = new Label("Welcome, Rubin");
        lblQuestion = new Label("What was the main focus of todays session?");

        rbCasual = new RadioButton();
        rbTraining = new RadioButton();
        if(rbCasual.isSelected()){
            rbTraining.setVisible(false);
        }else if(rbTraining.isSelected()){
            rbCasual.setDisable(true);
        }

        lblDate = new Label("Date");
        datePicker = new DatePicker();

        lblTime = new Label("HH:MM:SS");
        txfTime = new TextField();

        lblTrickPeformed = new Label("Trick Performed");
        cmbTrickPerformed = new ComboBox();
        cmbTrickPerformed.getItems().add("Ollie");
        cmbTrickPerformed.getItems().add("FS 180");
        cmbTrickPerformed.getItems().add("BS 180");
        cmbTrickPerformed.getItems().add("Shuvit");
        cmbTrickPerformed.getItems().add("Pop Shuvit");
        cmbTrickPerformed.getItems().add("Heel flip");
        cmbTrickPerformed.getItems().add("Kick flip");
        cmbTrickPerformed.getItems().add("Tre Flip");



        tabToday.setClosable(false);

        btnExit = new Button();
        btnExit.setOnAction(event -> System.exit(0));
        VBox vBox = new VBox(lblSkateArea, lblWelcome, lblQuestion, rbCasual, rbTraining,
                lblDate, datePicker, lblTime, lblTrickPeformed, cmbTrickPerformed, btnExit);
        tabToday.setContent(vBox);
        //tabToday.setContent(btnExit);

        //Table Log Tab
        tabLog = new Tab();
        tabLog.setText("Log");
        tabLog.setClosable(false);
        //TableView tableView = new TableView();
        //Initalizing and formatting columns
        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Entry, String>("date")
        );
        TableColumn timeCol = new TableColumn("Time");
        timeCol.setCellValueFactory(
                new PropertyValueFactory<Entry, String>("time")
        );
        TableColumn sessiontypeCol = new TableColumn<>("Session Type");
        sessiontypeCol.setCellValueFactory(
                new PropertyValueFactory<Entry, String>("sessionType")
        );
        TableColumn trickCol = new TableColumn<>("Trick Performed");
        trickCol.setCellValueFactory(
                new PropertyValueFactory<Entry, String>("trickPerformed")
        );        TableColumn successCol = new TableColumn<>("Success Rate");
        successCol.setCellValueFactory(
                new PropertyValueFactory<Entry, String>("successRate")
        );
        //Dummy data (Data will be added Dynamically through database in future.)
        logTable.setItems(data);
        logTable.getColumns().addAll(dateCol, timeCol, sessiontypeCol, trickCol, successCol);
        tabLog.setContent(logTable);



        //Progress Chart Tab (Ollie vs Kickflip vs FS180)
        tabProgress = new Tab();
        tabProgress.setText("Progress");
        //Progress Chart
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Success Rate");
        LineChart chartProgress = new LineChart(xAxis, yAxis);
        chartProgress.setTitle("Trick Progression");
        XYChart.Series<Number, Number> series1 = new XYChart.Series();
        XYChart.Series<Number, Number> series2 = new XYChart.Series();
        XYChart.Series<Number, Number> series3 = new XYChart.Series();

        series3.setName("FS 180");
        series2.setName("Kickflip");
        series1.setName("Ollie");
        //Dummy data (Data will be added Dynamically through Log in future.)
        series1.getData().add(new XYChart.Data(d1,40));
        series1.getData().add(new XYChart.Data(d2,45));
        series1.getData().add(new XYChart.Data(d3,55));
        series1.getData().add(new XYChart.Data(d4,60));
        series1.getData().add(new XYChart.Data(d5,65));
        series1.getData().add(new XYChart.Data(d6,70));
        series1.getData().add(new XYChart.Data(d7,85));
        series1.getData().add(new XYChart.Data(d8, 70));
        series1.getData().add(new XYChart.Data(d9, 66));
        series1.getData().add(new XYChart.Data(d10, 75));

        series2.getData().add(new XYChart.Data(d1,5));
        series2.getData().add(new XYChart.Data(d2,12));
        series2.getData().add(new XYChart.Data(d3,20));
        series2.getData().add(new XYChart.Data(d4,15));
        series2.getData().add(new XYChart.Data(d5,30));
        series2.getData().add(new XYChart.Data(d6,25));
        series2.getData().add(new XYChart.Data(d7,28));
        series2.getData().add(new XYChart.Data(d8,30));
        series2.getData().add(new XYChart.Data(d9,35));
        series2.getData().add(new XYChart.Data(d10,38));

        series3.getData().add(new XYChart.Data(d1,30));
        series3.getData().add(new XYChart.Data(d2,40));
        series3.getData().add(new XYChart.Data(d3,45));
        series3.getData().add(new XYChart.Data(d4,55));
        series3.getData().add(new XYChart.Data(d5,60));
        series3.getData().add(new XYChart.Data(d6,67));
        series3.getData().add(new XYChart.Data(d7,73));
        series3.getData().add(new XYChart.Data(d8,62));
        series3.getData().add(new XYChart.Data(d9,77));
        series3.getData().add(new XYChart.Data(d10,65));
        chartProgress.getData().add(series1);
        chartProgress.getData().add(series2);
        chartProgress.getData().add(series3);
        chartProgress.setPrefWidth(500);
        chartProgress.setPrefHeight(375);
        //chartProgress.setLegendVisible(false);
        tabProgress.setContent(chartProgress);
        tabProgress.setClosable(false);



        //Adding Tabs of LSD25
        tabPane = new TabPane();
        tabPane.getTabs().add(tabToday);
        tabPane.getTabs().add(tabLog);
        tabPane.getTabs().add(tabProgress);
        //Moving undecorated window
        tabPane.setOnMousePressed(e -> handleMousePressed(e));
        tabPane.setOnMouseDragged(e -> handleMouseDragged(e));

        mainPane.setCenter(tabPane);
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(mainPane);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();



    }



    public static void main(String[] args) {
        launch(args);
    }








    //Create 2 Mouse Handler classes - Drag undecorated box.
    protected void handleMousePressed(MouseEvent e){
        this.dragOffsetX = e.getScreenX() - stage.getX();
        this.dragOffsetY = e.getScreenY() - stage.getY();
    }

    protected void handleMouseDragged(MouseEvent e){

        stage.setX(e.getScreenX() - this.dragOffsetX);
        stage.setY(e.getScreenY() - this.dragOffsetY);

    }

    public static class Entry{
        private final SimpleStringProperty date;
        private final SimpleStringProperty time;
        private final SimpleStringProperty sessionType;
        private final SimpleStringProperty trickPerformed;
        private final SimpleStringProperty successRate;


        public Entry(String date, String time, String sessionType, String trickPerformed,
                     String successRate) {
            this.date = new SimpleStringProperty(date);
            this.time = new SimpleStringProperty(time);
            this.sessionType = new SimpleStringProperty(sessionType);
            this.trickPerformed = new SimpleStringProperty(trickPerformed);
            this.successRate = new SimpleStringProperty(successRate);
        }

        public String getDate() {
            return date.get();
        }


        public void setDate(String date) {
            this.date.set(date);
        }

        public String getTime() {
            return time.get();
        }

        public void setTime(String time) {
            this.time.set(time);
        }

        public String getSessionType() {
            return sessionType.get();
        }

        public void setSessionType(String sessionType) {
            this.sessionType.set(sessionType);
        }

        public String getTrickPerformed() {
            return trickPerformed.get();
        }


        public void setTrickPerformed(String trickPerformed) {
            this.trickPerformed.set(trickPerformed);
        }

        public String getSuccessRate() {
            return successRate.get();
        }

        public void setSuccessRate(String successRate) {
            this.successRate.set(successRate);
        }
    }

}

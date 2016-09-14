package Skate.Logic;
//TODO Make sure table display is working.
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Observable;

public class MainX extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<TableLog> logData = FXCollections.observableArrayList();

    public MainX(){
        logData.add(new TableLog("12/09/16", "00:30:00", "Training", "Ollie", 75.0));
        logData.add(new TableLog("14/09/16", "00:45:00", "Casual", "FS 180", 56.0));
        logData.add(new TableLog("15/09/16", "00:30:00", "Training", "Ollie", 77.75));
    }

    public ObservableList<TableLog>getLogData(){
        return logData;
    }


    public void showLog(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainX.class.getResource("SkateWindow.fxml"));
            AnchorPane skateLog = (AnchorPane) loader.load();

            rootLayout.setCenter(skateLog);

            LogController controller = loader.getController();
            controller.setMainX(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }




    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
                this.primaryStage.setTitle("Skate Log");
        initRootLayout();
        showSkateView();

    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainX.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showSkateView(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainX.class.getResource("SkateWindow.fxml"));
            TabPane skate = (TabPane) loader.load();

            rootLayout.setCenter(skate);


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

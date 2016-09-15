package Skate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LifeCycle extends Application {
    public LifeCycle(){
        String name = Thread.currentThread().getName();
        System.out.println("LifeCycle() Constructor: " + name);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void init() {
        String name = Thread.currentThread().getName();
        System.out.println("init() method: " + name);
    }

    public void start(Stage stage) {
        String name = Thread.currentThread().getName();
        System.out.println("start() method: " + name);

        Scene scene = new Scene(new Group(), 200, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFx Application Life Cycle");
        stage.show();
    }

    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }

}
//620 * 454
// still playing with resolution
//JavaFX lifecycle
//JavaFx 2 threads
// JavaFX Launcher
// JavaFX Application Thread
//Launch() method creates threads calling following methods:
// no-args constructor
// init() method
// start() method
// stop() method
//Main Components of JavaFX program
//Stage
//Scene
//Scene-Graph (gui components like button label etc...)

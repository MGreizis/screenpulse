package com.screenpulse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("StartPage"), 640, 480);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static <T> T getController(Parent root, Class<T> controllerClass) {
        FXMLLoader loader = (FXMLLoader) root.getProperties().get(FXMLLoader.class.getName());
        if (loader != null) {
            return loader.getController();
        } else {
            throw new IllegalStateException("FXMLLoader is missing in the root");
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
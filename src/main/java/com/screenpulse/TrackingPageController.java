package com.screenpulse;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TrackingPageController {

    public Label activeAppLabel;

    @FXML
    private void switchToStartPage() throws IOException {
        App.setRoot("StartPage");
    }

    public void updateActiveAppLabel(String appName) {
        Platform.runLater(() -> {
            activeAppLabel.setText("Active Application: " + appName);
        });
    }
}

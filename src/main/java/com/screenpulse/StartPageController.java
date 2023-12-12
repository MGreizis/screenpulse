package com.screenpulse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class StartPageController {

    @FXML
    private void onStartButtonClick(ActionEvent event) throws IOException {
        System.out.println("Start Tracking button clicked!");
        App.setRoot("TrackingPage");
    }

    @FXML
    private void onSettingsButtonClick(ActionEvent event) throws IOException {
        System.out.println("Settings button clicked!");
        App.setRoot("SettingsPage");
    }
}

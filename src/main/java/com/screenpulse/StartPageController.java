package com.screenpulse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StartPageController {

    @FXML
    private void onStartButtonClick(ActionEvent event) {
        System.out.println("Start Tracking button clicked!");
        // Add code to transition to the tracking view or perform relevant actions
    }

    @FXML
    private void onSettingsButtonClick(ActionEvent event) {
        System.out.println("Settings button clicked!");
        // Add code to transition to the settings view or perform relevant actions
    }
}

package com.screenpulse;

import java.io.IOException;
import javafx.fxml.FXML;

public class SettingsPageController {

    @FXML
    private void switchToStartPage() throws IOException {
        App.setRoot("StartPage");
    }
}
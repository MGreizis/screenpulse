module com.screenpulse {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.screenpulse to javafx.fxml;
    exports com.screenpulse;
}

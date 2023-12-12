module com.screenpulse {
    requires javafx.controls;
    requires javafx.fxml;
//    requires com.sun.jna;
    requires platform;
    requires jna;

    opens com.screenpulse to javafx.fxml;

    exports com.screenpulse;
}

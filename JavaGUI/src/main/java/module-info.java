module com.example.javagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.javagui to javafx.fxml;
    exports com.example.javagui;
}
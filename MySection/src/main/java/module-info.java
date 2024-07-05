module com.example.mysection {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.mysection to javafx.fxml;
    exports com.example.mysection;
}
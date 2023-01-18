module com.example.ironman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ironman to javafx.fxml;
    exports com.example.ironman;
}
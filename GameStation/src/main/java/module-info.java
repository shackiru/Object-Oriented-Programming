module com.example.gamestation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamestation to javafx.fxml;
    exports com.example.gamestation;
}
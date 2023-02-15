module com.example.abstraction {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abstraction to javafx.fxml;
    exports com.example.abstraction;
}
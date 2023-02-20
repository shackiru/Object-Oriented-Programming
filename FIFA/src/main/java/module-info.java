module com.example.fifa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fifa to javafx.fxml;
    exports com.example.fifa;
}
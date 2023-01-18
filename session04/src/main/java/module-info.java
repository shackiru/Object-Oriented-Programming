module com.example.session04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.session04 to javafx.fxml;
    exports com.example.session04;
}
module com.example.recursion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.recursion to javafx.fxml;
    exports com.example.recursion;
}
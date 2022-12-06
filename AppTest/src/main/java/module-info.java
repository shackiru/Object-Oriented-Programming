module com.example.apptest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apptest to javafx.fxml;
    exports com.example.apptest;
}
module com.example.foodcourt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.foodcourt to javafx.fxml;
    exports com.example.foodcourt;
}
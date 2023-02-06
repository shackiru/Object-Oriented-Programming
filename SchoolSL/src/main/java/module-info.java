module com.example.schoolsl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schoolsl to javafx.fxml;
    exports com.example.schoolsl;
}
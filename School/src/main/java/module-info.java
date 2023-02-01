module com.example.school {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.school to javafx.fxml;
    exports com.example.school;
}
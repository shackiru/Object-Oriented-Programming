module com.example.polymorphism {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.polymorphism to javafx.fxml;
    exports com.example.polymorphism;
}
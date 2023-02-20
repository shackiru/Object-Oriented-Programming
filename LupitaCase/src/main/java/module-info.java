module com.example.lupitacase {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lupitacase to javafx.fxml;
    exports com.example.lupitacase;
}
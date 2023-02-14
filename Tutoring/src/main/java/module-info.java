module com.example.tutoring {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.tutoring to javafx.fxml;
    exports com.example.tutoring;
}
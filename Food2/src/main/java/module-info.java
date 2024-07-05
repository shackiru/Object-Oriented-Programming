module shaq.food2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens shaq.food2 to javafx.fxml;
    exports shaq.food2;
}
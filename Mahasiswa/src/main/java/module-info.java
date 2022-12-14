module com.example.mahasiswa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mahasiswa to javafx.fxml;
    exports com.example.mahasiswa;
}
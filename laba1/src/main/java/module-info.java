module com.example.lab_2s {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_2s to javafx.fxml;
    exports com.example.lab_2s;
}
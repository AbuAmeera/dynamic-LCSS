module com.example.prj2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prj2 to javafx.fxml;
    exports com.example.prj2;
}
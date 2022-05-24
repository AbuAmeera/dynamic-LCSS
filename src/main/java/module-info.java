module com.example.prj1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prj1 to javafx.fxml;
    exports com.example.prj1;
}
module com.example.javafx_testing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_testing to javafx.fxml;
    exports com.example.javafx_testing;
}
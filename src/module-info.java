module newCopy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires javafx.base;

    opens application to javafx.base, javafx.graphics, javafx.fxml;
    opens BL to javafx.base; // Open the BL package to javafx.base
}

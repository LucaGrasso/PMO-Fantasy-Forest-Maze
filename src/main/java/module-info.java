module it.lucagrasso {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.logging;
    requires java.sql;

    opens it.lucagrasso.views.controller to javafx.fxml;

    exports it.lucagrasso;
}

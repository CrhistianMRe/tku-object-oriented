module com.crhistianm.javafxkps {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.crhistianm.javafxkps to javafx.fxml;
    exports com.crhistianm.javafxkps;
    exports com.crhistianm.javafxkps.controller;
    opens com.crhistianm.javafxkps.controller to javafx.fxml;
}
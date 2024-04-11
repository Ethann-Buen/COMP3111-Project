module comp3111.qsproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires javacsv;

    opens comp3111.qsproject to javafx.fxml;
    exports comp3111.qsproject;
}
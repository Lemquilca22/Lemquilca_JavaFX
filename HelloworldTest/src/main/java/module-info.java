module org.example.helloworldtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.helloworldtest to javafx.fxml;
    exports org.example.helloworldtest;
}
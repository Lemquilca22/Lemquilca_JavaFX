module org.example.helloworld {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.helloworld to javafx.fxml;
    exports org.example.helloworld;
}
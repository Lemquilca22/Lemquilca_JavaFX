module org.example.memory_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.memory_javafx to javafx.fxml;
    exports org.example.memory_javafx;
}
module com.example.loginui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.fasterxml.jackson.databind;

    exports com.example.loginui.User to com.fasterxml.jackson.databind;

    opens com.example.loginui to javafx.fxml;
    exports com.example.loginui;


}
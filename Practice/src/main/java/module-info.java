module ru.practice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens ru.practice to javafx.fxml;
    exports ru.practice.firstpractice;
    opens ru.practice.firstpractice to javafx.fxml;
}
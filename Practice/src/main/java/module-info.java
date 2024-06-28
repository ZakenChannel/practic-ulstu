module ru.practice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens ru.practice to javafx.fxml;
    exports ru.practice.firstpractice;
    exports ru.practice.secondpractice;
    exports ru.practice.thirdpractice;
    exports ru.practice.fourthpractice;
    opens ru.practice.firstpractice to javafx.fxml;
    opens ru.practice.secondpractice to javafx.fxml;
    opens ru.practice.thirdpractice to javafx.fxml;
    opens ru.practice.fourthpractice to javafx.fxml;
}
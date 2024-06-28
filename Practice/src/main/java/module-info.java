module ru.practice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.logging;

    opens ru.practice to javafx.fxml;
    exports ru.practice.firstpractice;
    exports ru.practice.secondpractice;
    exports ru.practice.thirdpractice;
    exports ru.practice.fourthpractice;
    exports ru.practice.fifthpractice;
    opens ru.practice.firstpractice to javafx.fxml;
    opens ru.practice.secondpractice to javafx.fxml;
    opens ru.practice.thirdpractice to javafx.fxml;
    opens ru.practice.fourthpractice to javafx.fxml;
    opens ru.practice.fifthpractice to javafx.fxml;
}
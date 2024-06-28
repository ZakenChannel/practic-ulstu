package ru.practice.sixthpractice;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {

    @FXML
    private TextField fieldX;
    @FXML
    private TextField resultY;
    @FXML
    private TextField resultS;

    @FXML
    private void calculate() {
        try {
            double x = Double.parseDouble(fieldX.getText());

            double y = (1 + 2 * x * x) * Math.exp(x * x);
            double s = 1;

            System.out.printf("x: %.2f, y: %.2f, s: %.2f%n", x, y, s);

            for (int i = 1; i <= 10; i++) {
                double k = 1;

                for (int j = 2; j <= i; j++) {
                    k *= j;
                }

                double slag = ((2 * i + 1) * Math.pow(x, 2 * i)) / k;
                s += slag;

                System.out.printf("Итерация %d: k: %.6f, slag: %.6f, s: %.6f%n", i, k, slag, s);
            }

            System.out.printf("Итого y: %.6f, s: %.6f%n", y, s);
            String formattedString = String.format("| %.2f\t| %.2f\t| %.2f\t|\n", x, y, s);
            System.out.println(formattedString);

            resultS.setText(String.format("%.6f", y));
            resultY.setText(String.format("%.6f", s));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: не удалось преобразовать введённое значение в число");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/SixthPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Practice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
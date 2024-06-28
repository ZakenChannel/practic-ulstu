package ru.practice.fifthpractice;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.*;

public class Controller extends Application {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при создании FileHandler", e);
        }
    }

    @FXML
    private TextField fieldX;
    @FXML
    private TextField resultY;
    @FXML
    private TextField resultS;

    @FXML
    private void calculate() {
        logger.log(Level.INFO, "Начало расчёта");
        try {
            int sign = 1;
            double x = Double.parseDouble(fieldX.getText().trim());
            logger.log(Level.INFO, "Входное значение x: " + x);
            double sum = 0;

            for (int i = 1; i <= 30; i++) {
                double temp = Math.pow(x, 2 * i + 1) / (2 * i - 1) / (2 * i + 1);
                temp *= sign;
                sum += temp;
                sign *= -1;
                logger.log(Level.FINE, "Итерация " + i + ", временное значение: " + temp + ", промежуточная сумма: " + sum);
            }

            double result = ((1 + x * x) / 2) * Math.atan(x) - (x / 2);
            logger.log(Level.INFO, "Результат Y: " + result);
            logger.log(Level.INFO, "Сумма S: " + sum);

            resultY.setText(String.valueOf(result));
            resultS.setText(String.valueOf(sum));
            logger.log(Level.INFO, "Результаты установлены в текстовые поля");

        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Ошибка ввода: не удалось преобразовать введённое значение в число", e);
        }
        logger.log(Level.INFO, "Конец расчёта");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/FifthPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Practice");
        stage.setScene(scene);
        stage.show();
    }

    static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return String.format("%1$tF %1$tT", record.getMillis()) +
                    " - " +
                    record.getLevel().getName() +
                    ": " +
                    formatMessage(record) +
                    System.lineSeparator();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
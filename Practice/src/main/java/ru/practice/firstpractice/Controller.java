package ru.practice.firstpractice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Controller extends Application {
    @FXML
    private Label textOfTask;
    @FXML
    private TextField firstCount;
    @FXML
    private TextField secondCount;
    @FXML
    private TextField numberFrom;
    @FXML
    private TextField numberTo;
    @FXML
    private TextField enterArray;
    @FXML
    private TextArea textOut;
    @FXML
    private Label result;

    private String currentAction = "";
    int[] oneDimensionalArray;
    int[][] twoDimensionalArray;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/FirstPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Practice");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonTaskClick(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String buttonText = sourceButton.getText();
        switch (buttonText) {
            case "Первое задание": {
                currentAction = "firstTask";

                textOfTask.setText("10. Дан целочисленный одномерный массив размера N. Серия – это" +
                        " последовательность элементов массива, идущих друг за другом. Знаки" +
                        " значений всех элементов серии одинаковы (все положительные или все" +
                        " отрицательные). Серия должна содержать минимум 2 элемента. Длина" +
                        " серии – количество элементов в серии. Найти серии с максимальной" +
                        " длиной для положительных чисел и отрицательных чисел. Вывести с" +
                        " какой позиции начинается каждая серия и длины серий.");
                break;
            }

            case "Второе задание": {
                currentAction = "secondTask";

                textOfTask.setText("11. Дан целочисленный одномерный массив размера N. Серия – это" +
                        " последовательность элементов массива, идущих друг за другом. Знаки" +
                        " значений всех элементов серии положительные. Серия должна" +
                        " содержать минимум 2 элемента. Длина серии – количество элементов в" +
                        " серии. Перенести после первого отрицательного элемента массива" +
                        " серию с наименьшей длиной");
                break;
            }

            case "Третье задание": {
                currentAction = "thirdTask";

                textOfTask.setText("12. Дан целочисленный одномерный массив размера N. Серия – это" +
                        " последовательность элементов массива, идущих друг за другом." +
                        " Каждый элемент серии делился нацело на предыдущий. Серия должна" +
                        " содержать минимум 2 элемента. Длина серии – количество элементов в" +
                        " серии. Добавить в конец каждой его серии еще один элемент" +
                        " (добавляется последний элемент в серии).");
                break;
            }

            case "Четвертое задание": {
                currentAction = "fourthTask";

                textOfTask.setText("9. Дан целочисленный одномерный массив размера N. Серия – это" +
                        " последовательность элементов массива, идущих друг за другом." +
                        " Значения всех элементов серии одинаково. Серия должна содержать" +
                        " минимум 2 элемента. Длина серии – количество элементов в серии." +
                        " Удалить из массива самую длинную серию.");
                break;
            }

            case "Пятое задание": {
                currentAction = "fifthTask";

                textOfTask.setText("10. Дан целочисленный двумерный массив размера N*N. Добавить столбец," +
                        " содержащий разницу между столбцами с минимальным и" +
                        " максимальным элементом после каждого столбца, в котором есть хотя" +
                        " бы один элемент, который является простым числом");
                break;
            }

            case "Шестое задание": {
                currentAction = "sixthTask";

                textOfTask.setText("11. Дан целочисленный двумерный массив размера N*N. Отсортировать" +
                        " матрицу по возрастанию ниже побочной диагонали. Направление: слева" +
                        " направо, сверху вниз.");
                break;
            }
        }
    }

    @FXML
    private void initArray(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String buttonText = sourceButton.getText();

        switch (buttonText) {
            case "Одномерный": {
                if (firstCount.getText().isEmpty()) {
                    showAlert("Введите размерность массива");
                    return;
                }

                if (numberFrom.getText().isEmpty() || numberTo.getText().isEmpty()) {
                    showAlert("Введите диапазон значений");
                    return;
                }

                if (twoDimensionalArray != null) twoDimensionalArray = Arrays.copyOf(twoDimensionalArray, 0);

                Random random = new Random();
                oneDimensionalArray = new int[Integer.parseInt(firstCount.getText())];

                for (int i = 0; i < oneDimensionalArray.length; i++) {
                    oneDimensionalArray[i] = random.nextInt(Integer.parseInt(numberFrom.getText()), Integer.parseInt(numberTo.getText()));
                }

                textOut.setText(Arrays.toString(oneDimensionalArray));
                break;
            }

            case "Двумерный": {
                if (firstCount.getText().isEmpty() || secondCount.getText().isEmpty()) {
                    showAlert("Введите размерность массива");
                    return;
                }

                if (numberFrom.getText().isEmpty() || numberTo.getText().isEmpty()) {
                    showAlert("Введите диапазон значений");
                    return;
                }

                if (twoDimensionalArray != null) twoDimensionalArray = Arrays.copyOf(twoDimensionalArray, 0);

                Random random = new Random();
                twoDimensionalArray = new int[Integer.parseInt(firstCount.getText())][Integer.parseInt(secondCount.getText())];

                for (int i = 0; i < Integer.parseInt(firstCount.getText()); i++) {
                    for (int j = 0; j < Integer.parseInt(secondCount.getText()); j++) {
                        twoDimensionalArray[i][j] = random.nextInt(Integer.parseInt(numberFrom.getText()), Integer.parseInt(numberTo.getText()));
                    }
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(firstCount.getText()); i++) {
                    for (int j = 0; j < Integer.parseInt(secondCount.getText()); j++) {
                        stringBuilder.append(twoDimensionalArray[i][j]).append("\t");
                    }
                    stringBuilder.append("\n");
                }

                textOut.setText(stringBuilder.toString());
                break;
            }

            case "Создать одномерный": {
                if (firstCount.getText().isEmpty() && secondCount.getText().isEmpty()) {
                    showAlert("Размерность массива не введена");
                    break;
                }

                if (enterArray.getText().isEmpty()) {
                    showAlert("Не введен массив");
                    break;
                }

                oneDimensionalArray = convertToArray(enterArray.getText(), Integer.parseInt(firstCount.getText()));
                if (oneDimensionalArray != null) textOut.setText(Arrays.toString(oneDimensionalArray));
                break;
            }

            case "Создать двумерный": {
                if (firstCount.getText().isEmpty() || secondCount.getText().isEmpty()) {
                    showAlert("Размерность массива не введена");
                    break;
                }

                if (enterArray.getText().isEmpty()) {
                    showAlert("Не введен массив");
                    break;
                }

                twoDimensionalArray = convertTo2DArray(enterArray.getText(), Integer.parseInt(firstCount.getText()), Integer.parseInt(secondCount.getText()));
                if (twoDimensionalArray != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < Integer.parseInt(firstCount.getText()); i++) {
                        for (int j = 0; j < Integer.parseInt(secondCount.getText()); j++) {
                            stringBuilder.append(twoDimensionalArray[i][j]).append(" \t");
                        }
                        stringBuilder.append("\n");
                    }

                    textOut.setText(stringBuilder.toString());
                }

                break;
            }
        }
    }

    @FXML
    private void executeTask() {
        if (currentAction.isEmpty()) {
            showAlert("Выберете задание");
            return;
        }

        switch (currentAction) {
            case "firstTask": {
                result.setText(FirstTask.findLongestSeries(oneDimensionalArray).toString());
                break;
            }

            case "secondTask": {
                result.setText(SecondTask.task(oneDimensionalArray));
                break;
            }

            case "thirdTask": {
                result.setText(Arrays.toString(ThirdTask.task(oneDimensionalArray)));
                break;
            }

            case "fourthTask": {
                result.setText(Arrays.toString(FourthTask.task(oneDimensionalArray)));
                break;
            }

            case "fifthTask": {
                result.setText(FifthTask.task(twoDimensionalArray));
                break;
            }

            case "sixthTask": {
                result.setText(SixthTask.task(twoDimensionalArray));
                break;
            }
        }
    }

    private int[] convertToArray(String input, int size) {
        String[] stringNumbers = input.split("\\s+");

        if (stringNumbers.length != size) {
            showAlert("Размер не совпал, проверьте введенные данные");
            return null;
        }

        int[] numbers = new int[stringNumbers.length];

        try {
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
        } catch (NumberFormatException e) {
            showAlert("Неправильный ввод");
            return null;
        }
        return numbers;
    }

    private int[][] convertTo2DArray(String input, int rows, int cols) {
        String[] stringNumbers = input.split("\\s+");

        if (stringNumbers.length != rows * cols) {
            showAlert("Размер не совпал, проверьте введенные данные");
            return null;
        }

        int[][] numbers = new int[rows][cols];

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    numbers[i][j] = Integer.parseInt(stringNumbers[i * cols + j]);
                }
            }
        } catch (NumberFormatException e) {
            showAlert("Неправильный ввод");
            return null;
        }
        return numbers;
    }


    private static void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ошибка");
        alert.setContentText(text);
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
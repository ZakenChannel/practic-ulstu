package ru.practice.secondpractice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Controller extends Application {
    @FXML
    private TextArea areaOutput;
    @FXML
    private TextArea areaGeneratingArray;
    @FXML
    private TextArea areaOfResult;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField firstTextField;
    @FXML
    private TextField secondTextField;


    private Queue<Integer> queue;
    private int[] arr;
    private List<int[]> steps;
    private List<int[]> highlights;
    private int currentStep;
    private boolean isSorted;
    private StoogeSorter sorter;

    public void initialize() {
        queue = new Queue<>();
        sorter = new StoogeSorter();
        currentStep = -1;
        isSorted = false;
    }

    @FXML
    private void buttonQueueClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        String name = button.getText();

        switch (name) {
            case "Добавить":
                queue.enqueue(new Random().nextInt(-100, 100));
                break;
            case "Удалить":
                if (queue.isEmpty()) {
                    showError("Очередь пуста, добавьте элементы");
                    break;
                }
                queue.dequeue();
                break;
            case "Вывести":
                areaOutput.clear();
                areaOutput.appendText(queue.toString());
                break;
        }
    }

    @FXML
    private void buttonSortClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        String name = button.getText();
        switch (name) {
            case "Сгенерировать массив": {
                generateArray();
                break;
            }
            case "Сортировать": {
                if (arr != null) {
                    sorter = new StoogeSorter();
                    sorter.sort(arr.clone());
                    steps = sorter.getSteps();
                    highlights = sorter.getHighlights();
                    currentStep = 0;
                    drawArray(steps.get(currentStep), -1, -1);
                }
                break;
            }
            case "Следующий шаг": {
                if (currentStep < steps.size() - 1) {
                    currentStep++;
                    int[] highlight = highlights.get(currentStep);
                    drawArray(steps.get(currentStep), highlight[0], highlight[1]);
                } else if (!isSorted) {
                    isSorted = true;
                    drawArray(steps.get(currentStep), -2, -2); // Highlight all in green
                }
                break;
            }
            case "Предыдущий шаг": {
                if (currentStep > 0) {
                    isSorted = false;
                    currentStep--;
                    int[] highlight = highlights.get(currentStep);
                    drawArray(steps.get(currentStep), highlight[0], highlight[1]);
                }
                break;
            }
        }
    }

    @FXML
    private void calculateDistance() {
        String firstLine = firstTextField.getText().trim();
        String secondLine = secondTextField.getText().trim();

        if (firstLine.isEmpty() || secondLine.isEmpty()) {
            showError("Одно из полей или оба поля не заполнены");
            return;
        }

        if (firstLine.split("\\s+").length > 1 || secondLine.split("\\s+").length > 1) {
            showError("Введите только одно слово");
            return;
        }

        int distance = LevenshteinDistance.task(firstLine, secondLine);
        areaOfResult.setText("Расстояние Левенштейна между \"" + firstLine + "\" и \"" + secondLine + "\" равно " + distance);
    }

    private void generateArray() {
        Random random = new Random();
        arr = new int[random.nextInt(5, 10)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-100, 100);
        }
        areaGeneratingArray.clear();
        areaGeneratingArray.appendText(Arrays.toString(arr));
    }

    private void drawArray(int[] array, int highlightIndex1, int highlightIndex2) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double width = canvas.getWidth() / array.length;
        double height = canvas.getHeight() / 2;

        for (int i = 0; i < array.length; i++) {
            if (highlightIndex1 == -2 && highlightIndex2 == -2) {
                gc.setFill(Color.LIGHTGREEN);
            } else if (i == highlightIndex1 || i == highlightIndex2) {
                gc.setFill(Color.LIGHTBLUE);
            } else {
                gc.setFill(Color.WHITE);
            }
            gc.fillRect(i * width, height - 20, width, 40);
            gc.setStroke(Color.BLACK);
            gc.strokeRect(i * width, height - 20, width, 40);
            gc.setFill(Color.BLACK);
            gc.fillText(String.valueOf(array[i]), i * width + width / 2 - 10, height);
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/secondPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Second practice");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
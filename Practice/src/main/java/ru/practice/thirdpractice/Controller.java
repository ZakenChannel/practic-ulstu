package ru.practice.thirdpractice;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.practice.thirdpractice.firsttask.*;
import ru.practice.thirdpractice.secondtask.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends Application {
    @FXML
    private TableView<Table> tableView;
    @FXML
    private TableColumn<Table, String> materialColumn;
    @FXML
    private TableColumn<Table, Integer> heightColumn;
    @FXML
    private TableColumn<Table, Integer> widthColumn;
    @FXML
    private TableColumn<Table, Integer> lengthColumn;
    @FXML
    private TableColumn<Table, String> colorColumn;

    @FXML
    private TextField materialField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField widthField;
    @FXML
    private TextField lengthField;
    @FXML
    private TextField colorField;

    @FXML
    private Canvas canvas;
    @FXML
    private TextField ovalX;
    @FXML
    private TextField ovalY;
    @FXML
    private TextField ovalWidth;
    @FXML
    private TextField ovalHeight;

    @FXML
    private TextField squareX;
    @FXML
    private TextField squareY;
    @FXML
    private TextField squareSide;

    @FXML
    private TextField fieldFirstNumber;
    @FXML
    private TextField fieldSecondNumber;
    @FXML
    private Label answer;

    private ObservableList<Table> tableData;
    private List<Oval> ovalList;
    private List<FilledSquare> filledSquareList;

    public void initialize() {
        tableData = FXCollections.observableArrayList();
        ovalList = new ArrayList<>();
        filledSquareList = new ArrayList<>();

        materialColumn.setCellValueFactory(cellData -> cellData.getValue().materialProperty());
        heightColumn.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        widthColumn.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
        lengthColumn.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
        colorColumn.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
    }

    @FXML
    private void handleCreateObjectTableButton(ActionEvent event) {
        Button source = (Button) event.getSource();
        String name = source.getText();

        switch (name) {
            case "Создать объект": {
                try {
                    String material = materialField.getText().trim();
                    String height = heightField.getText().trim();
                    String width = widthField.getText().trim();
                    String length = lengthField.getText().trim();
                    String color = colorField.getText().trim();

                    if (material.isEmpty() || height.isEmpty() || width.isEmpty() || length.isEmpty() || color.isEmpty()) {
                        showError("Перепроверьте поля");
                        break;
                    }

                    tableData.add(new Table(material, Integer.parseInt(height), Integer.parseInt(width), Integer.parseInt(length), color));
                    break;
                } catch (IllegalArgumentException ex) {
                    showError("Ошибка ввода данных: " + ex.getMessage());
                }
                break;
            }
            case "Показать объекты": {
                tableView.setItems(tableData);
                break;
            }
        }
    }

    @FXML
    private void handleCreateFigureButton(ActionEvent event) {
        Button source = (Button) event.getSource();
        String name = source.getText();
        switch (name) {
            case "Создать овал": {
                String x = ovalX.getText().trim();
                String y = ovalY.getText().trim();
                String width = ovalWidth.getText().trim();
                String height = ovalHeight.getText().trim();

                if (x.isEmpty() || y.isEmpty() || width.isEmpty() || height.isEmpty()) {
                    showError("Проверьте введенные значения");
                    break;
                }

                ovalX.setText("");
                ovalY.setText("");
                ovalWidth.setText("");
                ovalHeight.setText("");

                ovalList.add(new Oval(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(width), Integer.parseInt(height)));
                break;
            }
            case "Создать квадрат": {
                String x = squareX.getText().trim();
                String y = squareY.getText().trim();
                String side = squareSide.getText().trim();

                if (x.isEmpty() || y.isEmpty() || side.isEmpty()) {
                    showError("Проверьте введенные значения");
                    break;
                }

                squareX.setText("");
                squareY.setText("");
                squareSide.setText("");

                filledSquareList.add(new FilledSquare(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(side)));
                break;
            }
            case "Отрисовка объектов": {
                if (ovalList.isEmpty() && filledSquareList.isEmpty()) {
                    showError("Оба списка пусты, создайте новые объекты");
                    break;
                }

                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                if (!ovalList.isEmpty()) {
                    for (Oval o : ovalList) {
                        o.draw(gc);
                    }
                }

                if (!filledSquareList.isEmpty()) {
                    for (FilledSquare fs : filledSquareList) {
                        fs.draw(gc);
                    }
                }

                break;
            }
        }
    }

    @FXML
    private void calculatingQuotientButton() {
        try {
            Double firstNumber = Double.parseDouble(fieldFirstNumber.getText().trim());
            Double secondNumber = Double.parseDouble(fieldSecondNumber.getText().trim());

            Division<Double> doubleDivision = new Division<>(firstNumber, secondNumber);
            answer.setText(String.valueOf(doubleDivision.divide()));
        } catch (NumberFormatException ex){
            showError("Проверьте правильность введенных даннных");
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/thirdPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ThirdPractice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
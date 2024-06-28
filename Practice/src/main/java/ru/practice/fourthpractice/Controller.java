package ru.practice.fourthpractice;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {

    @FXML
    private TextField initialPopulation;
    @FXML
    private TextField growthRate;
    @FXML
    private TextField deathRate;
    @FXML
    private TableView<ObservableList<String>> tableView;
    @FXML
    private TableColumn<ObservableList<String>, String> yearColumn;
    @FXML
    private TableColumn<ObservableList<String>, String> countPopulation;
    @FXML
    private TableColumn<ObservableList<String>, String> comparePopulation;


    @FXML
    public void initialize() {
        yearColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(0)));
        yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        countPopulation.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(1)));
        countPopulation.setCellFactory(TextFieldTableCell.forTableColumn());

        comparePopulation.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(2)));
        comparePopulation.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    public void onCalculate() {
        int initialPop = Integer.parseInt(initialPopulation.getText());
        double growth = Double.parseDouble(growthRate.getText()) / 100;
        double death = Double.parseDouble(deathRate.getText()) / 100;

        int year = 2014;
        int currentPopulation = initialPop;
        int targetPopulation = initialPop * 2;

        tableView.getItems().clear();

        while (currentPopulation < targetPopulation) {
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(Integer.toString(year));
            row.add(Integer.toString(currentPopulation));
            row.add(currentPopulation >= (initialPop * 2) ? "Да" : "Нет");
            tableView.getItems().add(row);

            currentPopulation += (int) (currentPopulation * growth - currentPopulation * death);
            year++;
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ru/practice/FourthPracticeForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Practice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package ru.practice.fourthpractice;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PopulationData {
    private final IntegerProperty year;
    private final IntegerProperty population;

    public PopulationData(int year, int population) {
        this.year = new SimpleIntegerProperty(year);
        this.population = new SimpleIntegerProperty(population);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public int getYear() {
        return year.get();
    }

    public int getPopulation() {
        return population.get();
    }
}

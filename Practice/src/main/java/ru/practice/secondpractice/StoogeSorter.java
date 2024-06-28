package ru.practice.secondpractice;

import java.util.ArrayList;
import java.util.List;

public class StoogeSorter {
    private final List<int[]> steps;
    private final List<int[]> highlights;

    public StoogeSorter() {
        steps = new ArrayList<>();
        highlights = new ArrayList<>();
    }

    public void sort(int[] arr) {
        stoogeSort(arr, 0, arr.length - 1);
    }

    private void stoogeSort(int[] arr, int l, int r) {
        steps.add(arr.clone());
        highlights.add(new int[]{l, r});

        if (l >= r) {
            return;
        }

        if (arr[l] > arr[r]) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            steps.add(arr.clone());
            highlights.add(new int[]{l, r});
        }

        if (r - l + 1 > 2) {
            int t = (r - l + 1) / 3;
            stoogeSort(arr, l, r - t);
            stoogeSort(arr, l + t, r);
            stoogeSort(arr, l, r - t);
        }
    }

    public List<int[]> getSteps() {
        return steps;
    }

    public List<int[]> getHighlights() {
        return highlights;
    }
}

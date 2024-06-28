package ru.practice.firstpractice;

import java.util.Arrays;

public class SecondTask {
    public static String task(int[] array) {
        if (array == null) return "";

        int minLength = Integer.MAX_VALUE;
        int minStartIndex = -1;
        int currentStart = -1;
        int currentLength = 0;
        boolean inSeries = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (!inSeries) {
                    inSeries = true;
                    currentStart = i;
                    currentLength = 1;
                } else {
                    currentLength++;
                }
            } else {
                if (inSeries) {
                    if (currentLength >= 2 && currentLength < minLength) {
                        minLength = currentLength;
                        minStartIndex = currentStart;
                    }
                    inSeries = false;
                }
            }
        }
        if (inSeries && currentLength >= 2 && currentLength < minLength) {
            minLength = currentLength;
            minStartIndex = currentStart;
        }

        if (minStartIndex == -1)
            return "Нет серий положительных чисел.";

        int firstNegativeIndex = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                firstNegativeIndex = i;
                break;
            }
        }
        if (firstNegativeIndex == -1)
            return "Нет отрицательных элементов в массиве.";

        if (firstNegativeIndex < minStartIndex) {
            int tempStartIndex = firstNegativeIndex + 1;
            shiftSeries(array, minStartIndex, minLength, tempStartIndex);
        } else {
            int tempStartIndex = firstNegativeIndex + 1 - minLength;
            shiftSeries(array, minStartIndex, minLength, tempStartIndex);
        }

        return Arrays.toString(array);
    }

    private static void shiftSeries(int[] array, int seriesStart, int seriesLength, int targetStart) {
        if (seriesStart < targetStart) {
            for (int i = 0; i < seriesLength; i++) {
                int temp = array[seriesStart + i];
                for (int j = seriesStart + i; j < targetStart + i; j++) {
                    array[j] = array[j + 1];
                }
                array[targetStart + i] = temp;
            }
        } else if (seriesStart > targetStart) {
            for (int i = 0; i < seriesLength; i++) {
                int temp = array[seriesStart + i];
                for (int j = seriesStart + i; j > targetStart + i; j--) {
                    array[j] = array[j - 1];
                }
                array[targetStart + i] = temp;
            }
        }
    }
}

package ru.practice.firstpractice;

import java.util.ArrayList;
import java.util.List;

public class ThirdTask {
    public static int[] task(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        List<Integer> resultList = new ArrayList<>();
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] % array[i - 1] == 0) {
                currentLength++;
            } else {
                if (currentLength >= 2) {
                    for (int j = currentStart; j < currentStart + currentLength; j++) {
                        resultList.add(array[j]);
                    }
                    resultList.add(array[i - 1]);
                } else {
                    resultList.add(array[currentStart]);
                }
                currentStart = i;
                currentLength = 1;
            }
        }

        // Обработка последней серии
        if (currentLength >= 2) {
            for (int j = currentStart; j < currentStart + currentLength; j++) {
                resultList.add(array[j]);
            }
            resultList.add(array[array.length - 1]);
        } else {
            resultList.add(array[currentStart]);
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}

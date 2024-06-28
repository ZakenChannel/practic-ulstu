package ru.practice.firstpractice;

import java.util.ArrayList;
import java.util.List;

public class FourthTask {
    public static int[] task(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        int maxLength = 0;
        int maxStartIndex = -1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStartIndex = currentStart;
                }
                currentStart = i;
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStartIndex = currentStart;
        }

        if (maxLength < 2) {
            return array;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i < maxStartIndex || i >= maxStartIndex + maxLength) {
                resultList.add(array[i]);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

}

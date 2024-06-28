package ru.practice.firstpractice;

public class FirstTask {
    public static StringBuilder findLongestSeries(int[] array) {
        int maxPosStart = -1;
        int maxPosLength = 0;
        int maxNegStart = -1;
        int maxNegLength = 0;

        int currentStart = 0;
        int currentLength = 1;
        boolean isPositive = array[0] > 0;

        for (int i = 1; i < array.length; i++) {
            if ((array[i] > 0) == isPositive) {
                currentLength++;
            } else {
                if (isPositive && currentLength >= 2 && currentLength > maxPosLength) {
                    maxPosStart = currentStart;
                    maxPosLength = currentLength;
                } else if (!isPositive && currentLength >= 2 && currentLength > maxNegLength) {
                    maxNegStart = currentStart;
                    maxNegLength = currentLength;
                }

                currentStart = i;
                currentLength = 1;
                isPositive = array[i] > 0;
            }
        }

        // Check the last series
        if (isPositive && currentLength >= 2 && currentLength > maxPosLength) {
            maxPosStart = currentStart;
            maxPosLength = currentLength;
        } else if (!isPositive && currentLength >= 2 && currentLength > maxNegLength) {
            maxNegStart = currentStart;
            maxNegLength = currentLength;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (maxPosStart != -1) {
            stringBuilder.append("Самая длинная положительная серия начинается с индекса ").append(maxPosStart).append(" длина ").append(maxPosLength).append("\n");
        } else {
            stringBuilder.append("Положительных рядов не обнаружено\n");
        }

        if (maxNegStart != -1) {
            stringBuilder.append("Самая длинная отрицательная серия начинается с индекса ").append(maxNegStart).append(" длина ").append(maxNegLength);
        } else {
            stringBuilder.append("Отрицательных серий не найдено");
        }

        return stringBuilder;
    }
}

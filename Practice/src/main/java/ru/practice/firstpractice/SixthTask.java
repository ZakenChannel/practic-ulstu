package ru.practice.firstpractice;

import java.util.Arrays;

public class SixthTask {
    public static String task(int[][] array) {
        int n = array.length;
        int[] aboveDiagonal = new int[(n * (n - 1)) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                aboveDiagonal[index++] = array[i][j];
            }
        }

        Arrays.sort(aboveDiagonal);
        for (int i = 0; i < aboveDiagonal.length / 2; i++) {
            int temp = aboveDiagonal[i];
            aboveDiagonal[i] = aboveDiagonal[aboveDiagonal.length - 1 - i];
            aboveDiagonal[aboveDiagonal.length - 1 - i] = temp;
        }

        index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                array[i][j] = aboveDiagonal[index++];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int[] row : array) {
            for (int num : row) {
                stringBuilder.append(num).append("\t");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

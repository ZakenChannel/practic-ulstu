package ru.practice.firstpractice;

public class FifthTask {
    public static String task(int[][] array) {
        if (array == null) return "";

        int n = array.length;
        int m = array[0].length;
        int newColCount = m;

        for (int j = 0; j < m; j++) {
            for (int[] ints : array) {
                if (isPrime(ints[j])) {
                    newColCount++;
                    break;
                }
            }
        }

        int minInd = -1, maxInd = -1;
        int minEl = Integer.MAX_VALUE, maxEl = Integer.MIN_VALUE;

        for (int[] ints : array) {
            for (int j = 0; j < m; ++j) {
                if (ints[j] < minEl) {
                    minEl = ints[j];
                    minInd = j;
                }
                if (ints[j] > maxEl) {
                    maxEl = ints[j];
                    maxInd = j;
                }
            }
        }

        int[] diff = new int[n];

        for (int i = 0; i < n; ++i) {
            diff[i] = array[i][maxInd] - array[i][minInd];
        }

        int[][] newArray = new int[n][newColCount];
        int newColIndex = 0;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                newArray[i][newColIndex] = array[i][j];
            }
            newColIndex++;

            boolean hasPrime = false;
            for (int[] ints : array) {
                if (isPrime(ints[j])) {
                    hasPrime = true;
                    break;
                }
            }

            if (hasPrime) {
                for (int i = 0; i < n; i++) {
                    newArray[i][newColIndex] = diff[i];
                }
                newColIndex++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int[] row : newArray) {
            for (int num : row) {
                stringBuilder.append(num).append("\t");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private static boolean isPrime(int number) {
        number = Math.abs(number);
        if (number == 0 || number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

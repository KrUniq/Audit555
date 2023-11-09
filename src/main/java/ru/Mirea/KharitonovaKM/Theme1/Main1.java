package ru.Mirea.KharitonovaKM.Theme1;

import java.util.Arrays;
import java.util.Random;

public class Main1 {

    public static void main(String[] args) {
        int[] array = generateArray();
        String arrStr = Arrays.toString(array);
        System.out.println(arrStr);
        int z = calculateAverage(array);
        int task1Result = countValuesGreaterThanZ(array, z);
        int task2Result = findDifference(array);
        int task3Result = countElementsDivisibleByIndex(array);
        double task4Result = calculateGeometricMean(array);

        System.out.println("Task 1: " + task1Result);
        System.out.println("Task 2: " + task2Result);
        System.out.println("Task 3: " + task3Result);
        System.out.println("Task 4: " + task4Result);
    }

    private static int[] generateArray() {
        int n = calculateN();
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(201) - 100; // случайное значение от -100 до 100
        }

        return array;
    }

    private static int calculateN() {
        String birthDate = "01.07.2004";
        int sum = 0;

        for (char c : birthDate.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum * 2;
    }

    private static int calculateAverage(int[] array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    private static int countValuesGreaterThanZ(int[] array, int z) {
        int count = 0;

        for (int value : array) {
            if (value > z) {
                count++;
            }
        }

        return count;
    }

    private static int findDifference(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Min:" +min);
        System.out.println("Max:" +max);
        return max - min;
    }

    private static int countElementsDivisibleByIndex(int[] array) {
        int count = 0;
        System.out.println("Элементы, которые делятся без остатка:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % (i + 1) == 0) {
                count++;
                System.out.println(array[i]);
            }
        }

        return count;
    }

    private static double calculateGeometricMean(int[] array) {
        double product = 1.0;
        int count = 0;

        for (int i = 1; i < array.length; i += 2) {
            product *= array[i];
            count++;
        }
        return Math.pow(product, 1.0 / count);
    }
}
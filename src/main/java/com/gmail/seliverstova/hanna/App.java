package com.gmail.seliverstova.hanna;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] array = new int[2_000_000];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
        }
        int[] array2 = array.clone();
        int[] array3 = array.clone();

        long tstart = System.currentTimeMillis();
        shellSort(array, 0, array.length);
        long tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + "- Static method sort");

        tstart = System.currentTimeMillis();
        MultiThreadSorting.sort(array2, 3);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - MultiThread sort");

        tstart = System.currentTimeMillis();
        Arrays.sort(array3);
        tend = System.currentTimeMillis();
        System.out.println((tend - tstart) + " ms" + " - Array sort");
    }

    private static void shellSort(int[] array, int begin, int end) {
        for (int k = (end - begin) / 2; k > 0; k /= 2)
            for (int i = begin + k; i < end; i++)
                for (int j = i; (j - begin) >= k && array[j - k] > array[j]; j -= k)
                    swap(array, j, j - k);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

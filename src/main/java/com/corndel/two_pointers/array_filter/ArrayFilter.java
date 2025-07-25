package com.corndel.two_pointers.array_filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFilter {

    public static int[] getDistinctNumbersBruteForce(int[] arr) {
        if (arr.length < 1) {
            return new int[]{};
        }

        List<Integer> distinctNumbers = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                distinctNumbers.add(arr[i]);
            }
        }

        distinctNumbers.add(arr[arr.length - 1]);

        return distinctNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getDistinctNumbersTwoPointers(int[] arr) {
        if (arr.length < 1) {
            return new int[]{};
        }

        int[] copy = Arrays.copyOf(arr, arr.length);

        int write = 1;
        for (int read = 1; read < arr.length; read++) {
            if (arr[read] != arr[read - 1]) {
                copy[write] = arr[read];
                write++;
            }
        }

        return Arrays.copyOf(copy, write);
    }
}

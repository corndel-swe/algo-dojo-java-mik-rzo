package com.corndel.two_pointers.zero_shifter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroShifter {

    public static int[] shiftZerosBruteForce(int[] arr) {
        List<Integer> zeroNumbers = new ArrayList<>();
        List<Integer> nonZeroNumbers = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumbers.add(arr[i]);
            } else {
                nonZeroNumbers.add(arr[i]);
            }
        }

        int[] result = new int[arr.length];
        int index = 0;

        for (int nonZeroNumber : nonZeroNumbers) {
            result[index++] = nonZeroNumber;
        }

        for (int zeroNumber : zeroNumbers) {
            result[index++] = zeroNumber;
        }

        return result;
    }


    public static int[] shiftZerosTwoPointers(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        int write = 0;

        for (int read = 0; read < arr.length; read++) {
            if (arr[read] != 0) {
                copy[write] = arr[read];
                write++;
            }
        }

        for (int i = write; i < arr.length; i++) {
            copy[i] = 0;
        }

        return copy;
    }
}

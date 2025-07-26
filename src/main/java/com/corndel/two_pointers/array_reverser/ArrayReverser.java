package com.corndel.two_pointers.array_reverser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReverser {
    public static int[] reverseBruteForce(int[] arr) {
        if (arr.length < 1) {
            return new int[]{};
        }

        List<Integer> reversed = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            reversed.add(arr[i]);
        }

        return reversed.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] reverseTwoPointers(int[] arr) {
        if (arr.length < 1) {
            return new int[]{};
        }

        int[] copy = Arrays.copyOf(arr, arr.length);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = copy[left];
            copy[left] = copy[right];
            copy[right] = temp;

            left++;
            right--;
        }

        return copy;
    }

}

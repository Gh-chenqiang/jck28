package com.ceshiren.sorting;

import java.util.Arrays;

/**
 * @author chenqiang
 */
public class ShellSort {

    public static void shellSort(int[] array) {

        if (array != null && array.length >= 2) {
            int gap = array.length / 2;
            while (gap > 0) {
                for (int i = gap; i < array.length; i++) {
                    int pre = i - gap;
                    while (pre >= 0 && array[pre] > array[pre + gap]) {
                        int temp = array[pre];
                        array[pre] = array[pre + gap];
                        array[pre + gap] = temp;
                        pre -= gap;
                    }
                }
                gap /= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

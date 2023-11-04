package com.ceshiren.sorting;

import java.util.Arrays;

/**
 * @author chenqiang
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {

        if (arr != null && arr.length >= 2) {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j + 1] < arr[j]) {
                        flag = false;
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
                }
                //一趟下来是否发生位置交换
                if (flag){ break;}
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

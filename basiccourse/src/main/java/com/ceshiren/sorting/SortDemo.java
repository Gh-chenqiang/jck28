package com.ceshiren.sorting;

import java.util.*;

/**
 * @Author chenqiang
 * @create 2023/11/18 16:16
 */
public class SortDemo {

    public static void generateShape(int nums) {
        for (int i = 1; i <= nums; i++) {
            StringBuffer sb=new StringBuffer();
            for (int j = 1; j <= nums; j++) {
                sb.append("+");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 10, 20, 12, 10, 3};
        //selectSort(arr);
        //insertionSort(arr);
        generateShape(arr[3]);
        System.out.println(Arrays.toString(arr));
    }
}

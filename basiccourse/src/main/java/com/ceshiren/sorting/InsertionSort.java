package com.ceshiren.sorting;

import java.util.Arrays;

/**
 * @author chenqiang
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {

        if (arr != null && arr.length >= 2) {
            for(int i = 0;i < arr.length - 1;i++){
                // 将 i+1 位置的数插入 0 到 i 之间的数组，从后往前遍历
                // current 指 i+1 的位置元素，pre 指 0 到 i 中依次向前遍历的指针
                int current = arr[i+1];
                int pre = i;
                while(pre >= 0 && current < arr[pre]){
                    arr[pre+1] = arr[pre];
                    // 最后将原来 i+1 位置的元素放入现在 0 到 i+1 之间数组中正确的位置上
                    arr[pre] = current;
                    pre--;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,4,10,20,12,10,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

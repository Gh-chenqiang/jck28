package com.ceshiren.sorting;

import java.util.Arrays;

/**
 * @author chenqiang
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        // 从无序区间不断挑选出最小值，挑选n-1次(最后一次不用挑)
        for(int i = 0; i <arr.length-1 ; i++) {
            // i 下标左边是已排好序的元素，右边(包括i)是无序区间，
            // 最小值下标默认是无序区间第一个元素下标(也就是i)
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex=j; // 比较大小，取最小值下标并交换
                }
            }
            // 交换最小值与无序区间第一个元素
            int tmp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,3,2,4,2,6,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

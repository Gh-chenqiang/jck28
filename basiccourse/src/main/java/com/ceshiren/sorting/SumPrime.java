package com.ceshiren.sorting;

/**
 * @Author chenqiang
 * @create 2023/11/15 16:19
 */
public class SumPrime {
    public static void main(String[] args) {
        int sum =0;
        //i 为求和数字
        for (int i = 2; i < 100; i++) {
            boolean index = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    index = false;
                    break;
                }
            }
            if (index) {
                System.out.println(i);
                sum += i;
            }
        }
        //2,3,5,7,11,13,17,19
        System.out.println(sum);
    }
}

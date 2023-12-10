package com.ceshiren.practicetwo;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author chenqiang
 * @create 2023/11/21 01:06
 */
public class Solution {
    @Test
    void name() {
        int[] nums = {9,3,12,1,2,3};
        int[] gas = {2,3,4}, cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=gas.length-1;i>=0;i--){
            sum+=gas[i]-cost[i];
            if(sum>max){
                max=sum;
                index=i;
            }
        }
        return sum>=0?index:-1;
    }
}

package com.ceshiren.practicetwo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author chenqiang
 * @create 2023/11/27 02:14
 */
class RandomizedSet {
    Set set =new HashSet<>();
    HashMap<Integer,Object> map;
    private static final Object PRESENT=new Object();

    public RandomizedSet() {
        map = new HashMap<>();

    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,PRESENT);
            return true;
        }else {
            return false;
        }

    }

    public boolean remove(int val) {
        if (map.containsKey(val)){
            map.remove(val);
            return true;
        }else {
            return false;
        }

    }

    public int getRandom() {
       Iterator<Integer> it= map.keySet().iterator();
       int[] arr=new int[map.size()];
       int i =0;
        while (it.hasNext()){
            arr[i]= it.next();
            i++;
        }
        Random random=new Random();
        System.out.println(random.nextInt(map.size()));
        return arr[i];
    }
    @Test
    void test(){
        System.out.println(getRandom());
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

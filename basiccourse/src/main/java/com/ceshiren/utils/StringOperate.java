package com.ceshiren.utils;

/**
 * @Author chenqiang
 * @create 2023/11/4 22:29
 */
public class StringOperate {

    /**
     * 判断字符串是否包含英文字母
     * 包含=true,不包含=false
     */
    public boolean containsLetter(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
}

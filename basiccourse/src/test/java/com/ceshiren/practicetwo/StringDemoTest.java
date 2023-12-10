package com.ceshiren.practicetwo;

/**
 * @Author chenqiang
 * @create 2023/11/22 15:06
 */
public class StringDemoTest {
    /**
     * 自定义一个字符串，找其中最长的回文字符串
     */
    public static void main(String[] args) {
        String str = "abcabbaaabbcc";
        int length = str.length();
        String maxStr="";
        String reverse=new StringBuffer(str).reverse().toString();

        int x =0;
        int y =1;
        while (x<length&&y<=length){
           String subString = str.substring(x,y);
           if(reverse.contains(subString)){
               if(subString.contentEquals(new StringBuffer(subString).reverse()))
               if(subString.length()>maxStr.length()) {
                   maxStr=subString;
               }y++;
           }else {
               x++;
               y=x+1;
           }
        }
        System.out.println(maxStr);
    }
}

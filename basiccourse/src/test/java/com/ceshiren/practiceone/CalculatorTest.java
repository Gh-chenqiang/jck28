package com.ceshiren.practiceone;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalculatorTest {

    @Test
    void calculatorTest(){

        System.out.println("dev-第1次提交修改: one");

        System.out.println("dev-第2次提交修改: two");

        System.out.println("bugfix-第one次提交修改");

        System.out.println("bugfix-第two次提交修改");


        String string = "apple,banana;orange php";
        String[] str=string.split("[,; ]");
        System.out.println(Arrays.toString(str));

    }
}

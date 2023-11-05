package com.ceshiren;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalculatorTest {

    @Test
    void calculatorTest(){




        String string = "apple,banana;orange php";
        String[] str=string.split("[,; ]");
        System.out.println(Arrays.toString(str));

    }
}

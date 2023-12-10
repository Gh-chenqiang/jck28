package com.ceshiren;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setCalculator() {
        // 实例化 计算器
        calculator = new Calculator("求和运算");
    }

    @BeforeEach
    void setUp() {
        //生成并绑定ID
        calculator.initId();
    }

    @AfterAll
    static void tearDown() {
        // 关闭计算器
        calculator.close();
    }

    @AfterEach
    void destroyId() {
        calculator.destroyId();
    }

    @Test
    @Order(1)
    void sum() {

        assertAll("加法计算结果校验",
                () -> {
                    assertEquals(10, calculator.sum(-99, -98, -40, 0, 50, 98, 99));
                },
                () -> {
                    assertEquals("请输入范围内的整数！", Assertions.assertThrows(
                            IllegalArgumentException.class, () -> {
                                calculator.sum(-100, 0);
                            }).getMessage());
                },
                () -> {
                    assertEquals("请输入范围内的整数！", Assertions.assertThrows(
                            IllegalArgumentException.class, () -> {
                                calculator.sum(101, 2);
                            }).getMessage());
                },
                () -> {
                    assertEquals("integer is 100！", Assertions.assertThrows(
                            NumberFormatException.class, () -> {
                                calculator.sum(100, 1);
                            }).getMessage());
                }
        );
    }
}
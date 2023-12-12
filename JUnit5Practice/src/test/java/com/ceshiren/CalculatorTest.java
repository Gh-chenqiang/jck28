package com.ceshiren;

import com.ceshiren.entityClass.*;
import com.ceshiren.impl.DataUnitFactoryImpl;
import com.ceshiren.mapper.EntityFileMapping;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("计算器运算测试")
class CalculatorTest {

    private static Calculator calculator;
    private static DataUnitFactory dataUnitFactory;

    @BeforeAll
    static void setCalculator() {
        // 实例化 计算器
        calculator = new Calculator("初始化计算器");
        // 实例化 数据驱动工厂
        dataUnitFactory = new DataUnitFactoryImpl();
        //todo 连接数据库获取数据
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
        //释放资源
        calculator.destroyId();
    }

    @ParameterizedTest
    @MethodSource()
    @DisplayName("求和计算")
    @Description("连续加法计算及结果校验测试")
    @Order(1)
    void sumTest(SumEntity sumEntity) {

        assertAll("加法计算结果校验",
                () -> {
                    //正常流程计算成功。
                    if (sumEntity.getTestCaseName().contains("正常流程")) {
                        assertEquals(Integer.valueOf(sumEntity.getExpect()), calculator.sum(sumEntity.getNumbers()));
                    }
                },
                () -> {
                    //输入整数<-99|输入整数>99,超出计算范围
                    if (sumEntity.getTestCaseName().contains("异常流程")) {
                        assertEquals(sumEntity.getExpect(), Assertions.assertThrows(
                                IllegalArgumentException.class, () -> {
                                    calculator.sum(sumEntity.getNumbers());
                                }).getMessage());
                    }
                }
        );
    }

    static List<SumEntity> sumTest() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.SUM_ENTITY);
    }


    @ParameterizedTest
    @MethodSource("from100SubtractTest")
    @DisplayName("从100进行减法计算")
    @Description("从100进行减法计算及结果校验测试")
    @Order(2)
    void from100SubtractTest(From100SubEntity subEntity) {
        assertAll("从100进行减法",
                () -> {
                    //正常流程计算成功。
                    if (subEntity.getTestCaseName().contains("正常流程")) {
                        assertEquals(Integer.valueOf(subEntity.getExpect()), calculator.subtract(subEntity.getNumbers()));
                    }
                },
                () -> {
                    //输入整数<-99|输入整数>99,超出计算范围
                    if (subEntity.getTestCaseName().contains("异常流程")) {
                        assertEquals(subEntity.getExpect(), assertThrows(
                                IllegalArgumentException.class, () -> {
                                    calculator.subtract(subEntity.getNumbers());
                                }).getMessage());
                    }
                }
        );
    }

    static List<SumEntity> from100SubtractTest() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.FROM_100_SUB_ENTITY);
    }

    @ParameterizedTest
    @MethodSource("subtractTest")
    @DisplayName("两数减法计算")
    @Description("两数做减法计算及结果校验测试")
    @Order(3)
    void subtractTest(TwoNumSubEntity subEntity) {
        assertAll("两数做减法计算",
                () -> {
                    //正常流程计算成功。
                    assertEquals(Integer.valueOf(subEntity.getExpect()), calculator.subtract(subEntity.getX(), subEntity.getY()));
                }
        );

    }

    static List<TwoNumSubEntity> subtractTest() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.TWO_NUM_SUB_ENTITY);
    }

    @ParameterizedTest
    @MethodSource("averageTest")
    @DisplayName("求平均值")
    @Description("求平均值计算及结果校验测试")
    @Order(4)
    void averageTest(AverageEntity averageEntity) {
        // 期望结果转BigDecimal类型，并保留两位小数
        BigDecimal avgExpect = new BigDecimal(averageEntity.getExpect());
        BigDecimal finalAvgExpect = avgExpect.setScale(2, RoundingMode.HALF_UP);
        //求实际平均值
        double averageActual = calculator.average(averageEntity.getNumbers());
        // 实际平均值转BigDecimal 以四舍五入保留两位小数
        BigDecimal avgActual = new BigDecimal(averageActual);
        BigDecimal finalAvgActual = avgActual.setScale(2, RoundingMode.HALF_UP);
        assertAll("两数做减法计算",
                () -> {
                    assertEquals(finalAvgExpect, finalAvgActual);
                }
        );
    }

    static List<AverageEntity> averageTest() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.AVERAGE_ENTITY);
    }

    @ParameterizedTest
    @MethodSource()
    @DisplayName("字符串连续拼接")
    @Description("字符串连续拼接操作测试")
    @Order(5)
    void concatStrTest(ConcatStrEntity concatStrEntity) {
        assertAll("字符串拼接", () -> {
                    assertEquals(concatStrEntity.getExpect(), calculator.concatStr(concatStrEntity.getWords()));
                }
        );
    }

    static List<ConcatStrEntity> concatStrTest() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.CONCAT_STR_ENTITY);
    }
}
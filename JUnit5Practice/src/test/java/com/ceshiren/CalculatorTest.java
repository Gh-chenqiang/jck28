package com.ceshiren;

import com.ceshiren.entityClass.*;
import com.ceshiren.mapper.EntityFileMapping;
import com.ceshiren.utils.DataUnitFactory;
import com.ceshiren.utils.SqlJdbcUnitFactory;
import com.ceshiren.utils.TestDataFactory;
import com.ceshiren.utils.impl.DataUnitFactoryImpl;
import com.ceshiren.utils.impl.SqlJdbcUnitImpl;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("计算器运算测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    private static Calculator calculator;
    private static SqlJdbcUnitFactory sqlJdbcUnitFactory;
    private static DataUnitFactory dataUnitFactory;

    @BeforeAll
    static void setCalculator() throws IOException {
        // 实例化 计算器
        calculator = new Calculator("初始化计算器");
        //todo 连接数据库获取数据
        /**
         * // 添加测试数据准备，通过硬编码实现，实际使用从数据库中读取
         * List<SumEntity> addEntities = new ArrayList<>();
         * // 测试数据写入yaml文件
         * dataUnitFactory.dumpYamlData(EntityFileMapping.SUM_ENTITY, addEntities);
         */
        /*sqlJdbcUnitFactory=new SqlJdbcUnitImpl();
        final String sumSql="select adds.numbers,adds.expect from `junit5_data`.`add_numbers` adds where adds.id between ? and ?;";
        List<Integer> whereList = Arrays.asList(1,100);
        List<Map> maps = sqlJdbcUnitFactory.MysqlJdbcConnect(sumSql, whereList);
        dataUnitFactory =new DataUnitFactoryImpl();
        dataUnitFactory.dumpYamlData(EntityFileMapping.SUM_ENTITY,maps);*/
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

    // 加法求和计算动态测试
    @TestFactory
    @DisplayName("加法求和计算动态测试")
    @Description("连续加法计算及结果校验测试")
    @Order(1)
    Iterable<DynamicTest> sumTestIterable() throws IOException {
        //参数化，引入yaml文件数据驱动
        List<SumEntity> sumTestData = TestDataFactory.getSumTestData();
        // 创建迭代器
        Iterator<SumEntity> iterator = sumTestData.iterator();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest;
        while (iterator.hasNext()) {
            SumEntity next = iterator.next();
            if (Arrays.stream(next.getNumbers()).anyMatch(u -> u < -99)
                    | Arrays.stream(next.getNumbers()).anyMatch(u -> u > 99)) {
                dynamicTest = DynamicTest.dynamicTest("求和计算: 超出计算范围 " + (sumTestData.indexOf(next) + 1), () -> {
                    //allure测试报告显示每一个测试用例的参数
                    Allure.step(next.toString());
                    //输入整数<-99|输入整数>99,超出计算范围
                    assertEquals(next.getExpect(), Assertions.assertThrows(
                            IllegalArgumentException.class, () -> {
                                calculator.sum(next.getNumbers());
                            }).getMessage());
                });
            } else {
                dynamicTest = DynamicTest.dynamicTest("求和计算：计算正确 " + (sumTestData.indexOf(next) + 1), () -> {
                    Allure.step(next.toString());
                    //正常流程计算成功。
                    assertEquals(Integer.valueOf(next.getExpect()), calculator.sum(next.getNumbers()));
                });
            }
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    // 从100进行减法运算动态测试
    @TestFactory
    @DisplayName("从100进行减法计算")
    @Description("从100进行减法计算及结果校验测试")
    @Order(2)
    Iterable<DynamicTest> from100SubtractTest() throws IOException {
        //参数化，引入yaml文件数据驱动
        List<From100SubEntity> sumTestData = TestDataFactory.getFrom100SubTestData();
        // 创建迭代器
        Iterator<From100SubEntity> iterator = sumTestData.iterator();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest;
        while (iterator.hasNext()) {
            From100SubEntity next = iterator.next();
            if (Arrays.stream(next.getNumbers()).allMatch(u -> u < -99)
                    | Arrays.stream(next.getNumbers()).allMatch(u -> u > 99)) {
                dynamicTest = DynamicTest.dynamicTest("从100进行减法计算: 超出计算范围 " + (sumTestData.indexOf(next) + 1), () -> {
                    //allure测试报告显示每一个测试用例的参数
                    Allure.step(next.toString());
                    //输入整数<-99|输入整数>99,超出计算范围
                    assertEquals(next.getExpect(), Assertions.assertThrows(
                            IllegalArgumentException.class, () -> {
                                calculator.subtract(next.getNumbers());
                            }).getMessage());
                });
            } else {
                dynamicTest = DynamicTest.dynamicTest("从100进行减法计算：计算正确 " + (sumTestData.indexOf(next) + 1), () -> {
                    Allure.step(next.toString());
                    //正常流程计算成功。
                    assertEquals(Integer.valueOf(next.getExpect()), calculator.subtract(next.getNumbers()));
                });
            }
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    // 两数计算动态测试
    @TestFactory
    @DisplayName("两数减法计算")
    @Description("两数做减法计算及结果校验测试")
    @Order(3)
    Iterable<DynamicTest> subtractTest() throws IOException {
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        //参数化，引入yaml文件数据驱动
        List<TwoNumSubEntity> twoNumSubTestData = TestDataFactory.getTwoNumSubTestData();
        // 创建迭代器
        for (TwoNumSubEntity next : twoNumSubTestData) {
            DynamicTest dynamicTest = DynamicTest.dynamicTest("减法运算 " + (twoNumSubTestData.indexOf(next) + 1), () -> {
                // allure测试报告显示每一个测试用例的参数
                Allure.step(next.toString());
                // 正常流程计算成功。
                assertEquals(Integer.valueOf(next.getExpect()), calculator.subtract(next.getX(), next.getY()));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    // 求平均值运算动态测试
    @TestFactory
    @DisplayName("求平均值运算")
    @Description("求平均值计算及结果校验测试")
    @Order(4)
    Iterable<DynamicTest> averageTest() throws IOException {
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        List<AverageEntity> averageTestData = TestDataFactory.getAverageTestData();
        for (AverageEntity next : averageTestData) {
            Allure.step(next.toString());
            // 期望结果转 BigDecimal 类型，并保留两位小数
            BigDecimal avgExpect = new BigDecimal(next.getExpect());
            BigDecimal finalAvgExpect = avgExpect.setScale(2, RoundingMode.HALF_UP);
            // 求实际平均值
            double averageActual = calculator.average(next.getNumbers());
            // 实际平均值转BigDecimal,并以四舍五入保留两位小数
            BigDecimal avgActual = new BigDecimal(averageActual);
            BigDecimal finalAvgActual = avgActual.setScale(2, RoundingMode.HALF_UP);
            // 计算结果校验
            DynamicTest dynamicTest = DynamicTest.dynamicTest("求平均值计算 " + (averageTestData.indexOf(next) + 1), () -> {
                //添加allure测试报告步骤展示参数
                Allure.step(next.toString());
                assertEquals(finalAvgExpect, finalAvgActual);
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    //字符串连续拼接动态测试
    @TestFactory
    @DisplayName("字符串连续拼接")
    @Description("字符串连续拼接测试")
    @Order(5)
    Iterable<DynamicTest> concatStrTest() throws IOException {
        // 实例化返回对象类型: Collection集合
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        // 参数化，引入yaml文件数据驱动
        List<ConcatStrEntity> concatStrTestData = TestDataFactory.getConcatStrTestData();
        // 创建一个iterator迭代器
        for (ConcatStrEntity concatStrEntity : concatStrTestData) {
            //获取下一个参数实例
            // 添加allure步骤请求参数
            Allure.step(concatStrEntity.toString());
            // 动态测试用例实现
            DynamicTest dynamicTest = DynamicTest.dynamicTest("字符串连续拼接测试校验 " + (concatStrTestData.indexOf(concatStrEntity) + 1), () -> {
                Allure.step(concatStrEntity.toString());
                assertEquals(concatStrEntity.getExpect(), calculator.concatStr(concatStrEntity.getWords()));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }
}
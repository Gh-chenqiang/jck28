package com.ceshiren;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
        //释放资源
        calculator.destroyId();
    }

    @ParameterizedTest
    @Order(1)
    @Tag("sum求和")
    @DisplayName("加法运算及结果校验")
    @MethodSource()
    void sumTest(SumList sumList) {
           assertAll("加法运算及结果校验",
                    //正常流程计算成功。
                    () -> {
                        if(sumList.getTestCaseName().contains("正常流程")) {
                            assertEquals(Integer.parseInt(sumList.getExpect()), calculator.sum(sumList.getAddNumA(), sumList.getAddNumB()));
                        }
                    },

                   //异常流程计算失败
                   () -> {
                       if (sumList.getTestCaseName().contains("异常流程")){
                           assertEquals(sumList.getExpect(), Assertions.assertThrows(
                                   IllegalArgumentException.class, () -> {
                                       calculator.sum(sumList.getAddNumA(), sumList.getAddNumB());
                                   }).getMessage());

                       }
                   }
            );
    }

    // csv文件数据驱动，读取csv文件数据
    static List<SumList> sumTest() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        // 带着header 读取
        CsvSchema sumListSchema = CsvSchema.emptySchema().withHeader();
        //csvMapper.findAndRegisterModules();
        MappingIterator<SumList> sumList = csvMapper.readerFor(SumList.class)
                .with(sumListSchema)
                .readValues(new File("src/test/resources/calculator_sum.csv"));
        return sumList.readAll();
    }

}
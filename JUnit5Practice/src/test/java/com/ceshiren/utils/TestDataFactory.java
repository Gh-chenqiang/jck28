package com.ceshiren.utils;

import com.ceshiren.entityClass.*;
import com.ceshiren.mapper.EntityFileMapping;
import com.ceshiren.utils.impl.DataUnitFactoryImpl;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/13 01:06
 */
public class TestDataFactory {
    private static final DataUnitFactory dataUnitFactory =new DataUnitFactoryImpl();
    // 用于返回测试数据的静态方法的工厂类，可被 @MethodSource 进行调用
    public static List<SumEntity> getSumTestData() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.SUM_ENTITY);
    }

    public static List<From100SubEntity> getFrom100SubTestData() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.FROM_100_SUB_ENTITY);
    }

    public static List<TwoNumSubEntity> getTwoNumSubTestData() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.TWO_NUM_SUB_ENTITY);
    }

    public static List<AverageEntity> getAverageTestData() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.AVERAGE_ENTITY);
    }

    public static List<ConcatStrEntity> getConcatStrTestData() throws IOException {
        return dataUnitFactory.YamlUnitFactory(EntityFileMapping.CONCAT_STR_ENTITY);
    }
}

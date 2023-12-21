package com.ceshiren.utils;

import com.ceshiren.DataEntity.CapsEntity;
import com.ceshiren.mapper.EntityFileMapping;
import com.ceshiren.utils.impl.DataUtilFactoryImpl;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/13 01:06
 */
public class TestDataFactory {
    private static final DataUtilFactory dataUnitFactory =new DataUtilFactoryImpl();
    // 用于返回测试数据的静态方法的工厂类，可被 @MethodSource 进行调用
    public static List<CapsEntity> getCapsData() throws IOException {
        return dataUnitFactory.YamlUtilFactory(EntityFileMapping.CAPS_ENTITY);
    }

}

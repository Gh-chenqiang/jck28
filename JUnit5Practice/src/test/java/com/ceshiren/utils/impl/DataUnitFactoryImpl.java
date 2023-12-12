package com.ceshiren.utils.impl;

import com.ceshiren.utils.DataUnitFactory;
import com.ceshiren.mapper.EntityFileMapping;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/12 20:07
 */
public class DataUnitFactoryImpl implements DataUnitFactory {

    static final String TEST_DATA_FILE_PATH = "src/test/resources/data/";
    private static ObjectMapper objectMapper;

    @Override
    public  <T> List<T> YamlUnitFactory(EntityFileMapping entityFileMap) throws IOException {
        // 实例化Yaml工厂
        objectMapper = new ObjectMapper(new YAMLFactory());
        // 指定Yaml文件路径
        File file = new File(TEST_DATA_FILE_PATH + entityFileMap.getFilePath());
        // 获取一个 TypeFactory 实例，用于指定返回List实例对象JavaType
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        // 指定范型类型为的type
        JavaType javaType = typeFactory.constructParametricType(List.class, entityFileMap.getEntityClass());
        return objectMapper.readValue(file, javaType);
    }

    @Override
    public <T> void dumpYamlData(EntityFileMapping entityFileMap, List<T> dataList) throws IOException {
        // 判断list是否为空
        if(dataList.isEmpty()){
            throw new IllegalArgumentException("数组长度不应为零");
        }
        // 判断类型是否一致
        if(!dataList.get(0).getClass().equals(entityFileMap.getEntityClass())){
            throw new ClassCastException("列表类型与文件类型不匹配");
        }
        // 指定yaml文件路径
        File file = new File(TEST_DATA_FILE_PATH + entityFileMap.getFilePath());
        objectMapper.writeValue(file,dataList);
    }

    @Override
    public <T> List<T> JsonUnitFactory(String JsonPath) throws IOException {
        objectMapper = new ObjectMapper(new JsonFactory());
        return null;
    }
}

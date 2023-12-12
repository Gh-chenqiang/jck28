package com.ceshiren.impl;

import com.ceshiren.DataUnitFactory;
import com.ceshiren.entityClass.SumEntity;
import com.ceshiren.mapper.EntityFileMapping;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.aspectj.apache.bcel.classfile.Field;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/12 20:07
 */
public class DataUnitFactoryImpl implements DataUnitFactory {

    static final String TEST_DATA_FILE_PATH = "src/test/resources/data/";
    private ObjectMapper objectMapper;

    @Override
    public <T> List<T> YamlUnitFactory(EntityFileMapping entityFileMap) throws IOException {

        objectMapper = new ObjectMapper(new YAMLFactory());
        File file = new File(TEST_DATA_FILE_PATH + entityFileMap.getFilePath());
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        JavaType javaType = typeFactory.constructParametricType(List.class, entityFileMap.getEntityClass());
        TypeReference<List<SumEntity>> typeReference = new TypeReference<List<SumEntity>>(){};
        return objectMapper.readValue(file, javaType);
    }

    @Override
    public <T> List<T> JsonUnitFactory(String JsonPath) throws IOException {
        objectMapper = new ObjectMapper(new JsonFactory());
        return null;
    }
}

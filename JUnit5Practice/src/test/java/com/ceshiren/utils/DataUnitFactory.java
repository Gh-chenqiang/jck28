package com.ceshiren.utils;

import com.ceshiren.mapper.EntityFileMapping;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/12 20:04
 */
public interface DataUnitFactory {
    // yaml文件数据驱动工厂，读取yaml文件数据
     <T> List<T> YamlUnitFactory(EntityFileMapping entityFileMap) throws IOException;
    // 读取数据库数据后，写入实体类列表对应的yaml文件中，以便查阅
    <T> void dumpYamlData(EntityFileMapping entityFileMap, List<T> dataList) throws IOException;

    // Json文件数据驱动工厂，读取Json文件数据
    <T> List<T> JsonUnitFactory(String JsonPath) throws IOException;
}

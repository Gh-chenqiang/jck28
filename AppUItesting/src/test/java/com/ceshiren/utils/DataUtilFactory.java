package com.ceshiren.utils;

import com.ceshiren.mapper.EntityFileMapping;

import java.io.IOException;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/12/21 17:42
 */
public interface DataUtilFactory {
    // yaml 文件数据驱动，读取 yaml文件数据
    <T> List<T> YamlUtilFactory(EntityFileMapping entityFileMap) throws IOException;

    // 读取数据库数据后，写入yaml文件，以便查阅数据正确性
    <T> void dumpYamlData(EntityFileMapping entityFileMap,List<T> dataList) throws IOException ;
}

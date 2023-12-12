package com.ceshiren;

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

    // Json文件数据驱动工厂，读取Json文件数据
    <T> List<T> JsonUnitFactory(String JsonPath) throws IOException;
}

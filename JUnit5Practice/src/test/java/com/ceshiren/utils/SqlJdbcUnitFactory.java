package com.ceshiren.utils;

import com.ceshiren.mapper.EntityFileMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author chenqiang
 * @create 2023/12/15 19:49
 */
public interface SqlJdbcUnitFactory {

    <T> List<Map> MysqlJdbcConnect(String queryPre, List<T> whereList);

}

package com.ceshiren.utils.impl;

import com.ceshiren.mapper.EntityFileMapping;
import com.ceshiren.utils.SqlJdbcUnitFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenqiang
 * @create 2023/12/15 20:49
 */
public class SqlJdbcUnitImpl implements SqlJdbcUnitFactory {

    private static final String MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/junit5_data?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&autoReconnect=true&useSSL=false&allowMultiQueries=true&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static ObjectMapper objectMapper;
    @Override
    public <T> List<Map> MysqlJdbcConnect(String queryPre, List<T> whereList) {
        try {
            Connection conn = DriverManager.getConnection(MYSQL_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(queryPre, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for (int i = 0; i < whereList.size(); i++) {
                ps.setObject(i + 1, whereList.get(i));
            }
            ResultSet res = ps.executeQuery();
            List list = new ArrayList();
            ResultSetMetaData md = res.getMetaData();//获取键名
            int columnCount = md.getColumnCount();//获取行的数量
            while (res.next()) {
                Map rowData = new HashMap();//声明Map
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), res.getObject(i));//获取键名及值
                }
                list.add(rowData);
            }
            ps.close();
            res.close();
            conn.close();
            return list;
            }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }


}

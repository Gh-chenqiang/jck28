package com.ceshiren.mapper;

import com.ceshiren.DataEntity.CapsEntity;
import lombok.Getter;

/**
 * @Author chenqiang
 * @create 2023/12/21 17:22
 */
@Getter
public enum EntityFileMapping {
    // 保存实体类与数据文件的对应关系
    CAPS_ENTITY(CapsEntity.class, "caps-data.yaml");

    private final Class<?> entityClass;
    private final String filePath;

    EntityFileMapping(Class<?> entityClass, String filePath) {
        this.entityClass = entityClass;
        this.filePath = filePath;
    }
}

package com.ceshiren.mapper;

import com.ceshiren.entityClass.*;
import lombok.Getter;

/**
 * @Author chenqiang
 * @create 2023/12/12 22:02
 */
@Getter
public enum EntityFileMapping {
    // 保存实体类与文件的对应关系
    SUM_ENTITY(SumEntity.class, "sum-data.yaml"),
    FROM_100_SUB_ENTITY(From100SubEntity.class, "from100Sub-data.yaml"),
    TWO_NUM_SUB_ENTITY(TwoNumSubEntity.class, "twoNumSub-data.yaml"),
    AVERAGE_ENTITY(AverageEntity.class, "average-data.yaml"),
    CONCAT_STR_ENTITY(ConcatStrEntity.class, "concatStr-data.yaml");

    private final Class<?> entityClass;
    private final String filePath;

    EntityFileMapping(Class<?> entityClass, String filePath) {
        this.entityClass = entityClass;
        this.filePath = filePath;
    }
}

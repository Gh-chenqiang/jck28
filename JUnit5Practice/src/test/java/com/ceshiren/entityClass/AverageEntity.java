package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 求平均值参数实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AverageEntity {
    private int[] numbers;
    private String expect;
}

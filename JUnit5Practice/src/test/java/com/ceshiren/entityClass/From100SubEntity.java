package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 从100进行减法参数实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class From100SubEntity {
    private String testCaseName;
    private int[] numbers;
    private String expect;
}

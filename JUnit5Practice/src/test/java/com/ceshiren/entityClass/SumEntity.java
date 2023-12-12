package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *求和加数参数实体类
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SumEntity {
    private String testCaseName;
    private int[] numbers;
    private String expect;
}

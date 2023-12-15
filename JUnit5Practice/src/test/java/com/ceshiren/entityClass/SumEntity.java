package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *求和加数参数实体类
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class SumEntity {
    private int[] numbers;
    private String expect;
}

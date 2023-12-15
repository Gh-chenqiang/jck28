package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 从100进行减法参数实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class From100SubEntity {
    private int[] numbers;
    private String expect;
}

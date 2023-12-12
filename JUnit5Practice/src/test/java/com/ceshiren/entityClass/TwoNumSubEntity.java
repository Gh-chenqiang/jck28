package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 两数减法参数实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TwoNumSubEntity {
    private int x;
    private int y;
    private String expect;
}

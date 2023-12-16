package com.ceshiren.entityClass;

import lombok.*;

/**
 *求和加数参数实体类
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SumEntity {
    private int[] numbers;
    private String expect;
}

package com.ceshiren.entityClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 连续字符串拼接参数实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ConcatStrEntity {
    private String[] words;
    private String expect;
}
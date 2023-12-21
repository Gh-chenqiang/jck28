package com.ceshiren.DataEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * caps配置实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CapsEntity {
    private String platformName;
    private String platformVersion;
    private String udid;
    private String automationName;
    private String appPackage;
    private String appActivity;
    private String noReset;
    //ios 专属部分
    private String bundleId;

}

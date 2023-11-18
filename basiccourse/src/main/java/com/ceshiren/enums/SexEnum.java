package com.ceshiren.enums;

import com.ceshiren.Exception.InputSexException;

import java.util.Objects;

/**
 * @Author chenqiang
 * @create 2023/11/5 21:33
 */
public enum SexEnum {

    MAN("男"),
    FEMALE("女");
    private final String sex;

    SexEnum(String sex){
        this.sex =sex;
    }

    public String getSex(){
        return this.sex;
    }

    public static SexEnum getBySex(String sex){
        for (SexEnum sexEnum:values()) {
            if(sex.equals(sexEnum.getSex())){
                return sexEnum;
            }
        }
        return null;
    }

    public static SexEnum checkSex(String sex) throws InputSexException {
        SexEnum sx;
        if (sex.isEmpty()){
            throw new InputSexException("性别不能为空~");
        }
        if (MAN.equals(SexEnum.getBySex(sex))) {
            sx = SexEnum.MAN;
        }else if(FEMALE.equals(SexEnum.getBySex(sex))) {
            sx = SexEnum.FEMALE;
        }else {
            throw new InputSexException("请输入正确的性别");
        }
        return sx;
    }
}

package com.ceshiren.javacourse;

import com.ceshiren.enums.SexEnum;

/**
 * @author chenqiang
 */
public class Student {

    private Integer snu;
    private String name;

    private SexEnum sex ;

    public Student(Integer snu, String name, SexEnum sex) {
        this.snu=snu;
        this.name=name;
        this.sex=sex;
    }

    public int getSnu() {
        return snu;
    }

    public void setSnu(int snu) {
        this.snu = snu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    /**
     * 学员信息拼接
     * @param student
     * @return
     */
    public StringBuffer appendStu(Student student){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("学号: ")
                .append(student.getSnu())
                .append(", 姓名: ")
                .append(student.getName())
                .append(", 性别: ")
                .append(student.getSex());
        return stringBuffer;
    }
}

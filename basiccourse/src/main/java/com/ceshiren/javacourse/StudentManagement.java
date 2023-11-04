package com.ceshiren.javacourse;

import java.util.*;

/**
 * @author chenqiang
 */
public class StudentManagement {
    private static final String PREFIX="2023";
    private static int counter=0;

    public synchronized static String generate(){
        counter++;
        return PREFIX+String.format("%04d",counter);
    }

    public static Student addStudent(int snu, String name, String sex){
        Student student =new Student();
        student.setSnu(snu);
        student.setName(name);
        student.setSex(sex);
        return student;
    }

    public static void deleteStudentByName(String name , List<Student> students) {
        if (!students.isEmpty()) {
            students.removeIf(student -> Objects.equals(name, student.getName()));
        }
        System.out.println("删除后的学员信息:");
        for(Student student:students){
            System.out.println(appendStu(student));
        }
    }

    public static void deleteStudentBySnu(int snu , List<Student> students) {
        if (!students.isEmpty()) {
            students.removeIf(student -> Objects.equals(snu, student.getSnu()));
        }
    }

    public static Optional queryStudent(int snu,List<Student> students){
        Student student=null;
        if(!students.isEmpty()) {
            for (Student stu : students) {
                if (stu.getSnu() == snu) {
                    student=stu;
                }
            }
        }
        Optional<Student> opt=Optional.ofNullable(student);
        if(opt.isPresent()){
            StringBuffer stringBuffer=appendStu(student);
            return Optional.of(stringBuffer);
        }else {
            return opt;
        }
    }

    public static StringBuffer appendStu(Student student){
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

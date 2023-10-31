package com.ceshiren.javacourse;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private static final String PREFIX="2023";
    private static int counter=0;

    public synchronized static String generate(){
        counter++;
        return PREFIX+String.format("%04d",counter);
    }

    public static Student addStudent(int id, String name, String sex){
        Student student =new Student();
        student.setId(id);
        student.setName(name);
        student.setSex(sex);
        return student;
    }

    public static List<Student> deleteStudent(String name ,List<Student> students) {
        if (students.size() > 0) {
            students.removeIf(student -> name == student.getName());
            /*            students.forEach(student -> {
                if (student.getId() == id) {
                    students.remove(student);
                }
            });*/

        }
        return students;
    }

    //todo 实现输入学生信息然后添加到系统中

    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();

        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"张三","男"));
        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"莉丝","女"));
        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"王武","男"));
        System.out.println("添加的学员信息:");
        for(Student student:students){
            System.out.println("学号："+student.getId()+ "，姓名："+ student.getName()+"，性别："+student.getSex());
        }

        students=StudentManagement.deleteStudent("莉丝",students);
        System.out.println("删除后的学员信息:");
        for(Student student:students){
            System.out.println("学号："+student.getId()+ "，姓名："+ student.getName()+"，性别："+student.getSex());
        }


    }
}

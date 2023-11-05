package com.ceshiren.javacourse.impl;

import com.ceshiren.Exception.InputIdException;
import com.ceshiren.Exception.InputSexException;
import com.ceshiren.Exception.NotExistException;
import com.ceshiren.enums.SexEnum;
import com.ceshiren.javacourse.Student;
import com.ceshiren.javacourse.StudentManagement;

import java.util.*;

/**
 * @author chenqiang
 */
public class StudentManagementImpl implements StudentManagement {
    Map<Integer,Student> students;
    private static final String PREFIX="2023";
    private static int counter=0;

    @Override
    public void initData(){students=new HashMap<>();}

    @Override
    public synchronized String generate(){
        counter++;
        return PREFIX+String.format("%04d",counter);
    }

    @Override
    public void addStudent(Integer snu, String name, String sex) throws InputIdException, InputSexException {

        if (students.containsKey(snu)){
            throw new InputIdException("学生id已存在~");
        }
        SexEnum sx=SexEnum.checkSex(sex);
        students.put(snu,new Student(snu,name,sx));
        System.out.println("添加学员成功");
    }

    @Override
    public void deleteStudentByName(String name, Map<Integer,Student> students) throws NotExistException {
        if (!students.isEmpty()) {
            System.out.println("删除后的学员信息");
            students.forEach((key,value) -> {
                if(name.equals(value.getName())){
                    students.remove(value.getSnu());
                    System.out.println(value.appendStu(value));
                }
            }
            );
        }else {
            throw new NotExistException("系统不存在学员信息，请录入学员信息~");
        }
    }

    @Override
    public void deleteStudentBySnu(Integer sno, Map<Integer,Student> students) throws NotExistException {
        if (!students.isEmpty()) {
            if(!students.containsKey(sno)){
                throw new NotExistException("系统不存在学员id信息~");
            }
            System.out.println("删除后的学员信息");
            students.forEach((key, value) -> {
                        if (sno.equals(value.getSnu())) {
                            students.remove(sno);
                            System.out.println(value.appendStu(value));
                        }
                    }
            );
        }else {
            throw new NotExistException("系统不存在学员信息，请录入学员信息~");
        }
    }
        @Override
        public Optional queryStudent (Integer sno, Map < Integer, Student > students){
            Student student=null;
            if (!students.isEmpty()) {
                for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                    Student value = entry.getValue();
                    if (value.getSnu() == sno) {
                        student = value;
                    }
                }
                Optional<Student> opt= Optional.ofNullable(student);
                if (opt.isPresent()) {
                    return Optional.of(student.appendStu(student));
                } else {
                    return opt;
                }
            }
            return Optional.empty();
        }
}

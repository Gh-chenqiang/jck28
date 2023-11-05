package com.ceshiren.javacourse;

import com.ceshiren.Exception.NotExistException;
import com.ceshiren.enums.SexEnum;
import com.ceshiren.javacourse.impl.StudentManagementImpl;
import com.ceshiren.utils.MenuNumException;
import com.ceshiren.utils.SnuInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenqiang
 * @create 2023/11/4 21:31
 */
public class StudentDemo {
    private final StudentManagement studentManagement;
    private final StudentSys studentSys=new StudentSys(new StudentManagementImpl());

    public StudentDemo(StudentManagement studentManagement) {
        // 通过接口进行实现
        this.studentManagement = studentManagement;
    }

    public void run () throws MenuNumException, NotExistException {

        Map<Integer,Student> students=new HashMap<>();

        Integer sno1 =Integer.parseInt(studentManagement.generate());
        Integer sno2 =Integer.parseInt(studentManagement.generate());
        Integer sno3 =Integer.parseInt(studentManagement.generate());
        students.put(sno1,new Student(sno1,"张三", SexEnum.MAN));
        students.put(sno2,new Student(sno2,"莉丝", SexEnum.FEMALE));
        students.put(sno3,new Student(sno3,"莉丝", SexEnum.MAN));
        System.out.println("添加的学员信息:");
        students.forEach((key,value)-> System.out.println(value.appendStu(value)));
        studentManagement.deleteStudentByName("莉丝", students);

        studentSys.scannerStu(students);
    }

    public static void main(String[] args) {
        try {
            new StudentDemo(new StudentManagementImpl()).run();
        } catch (MenuNumException | NotExistException e) {
            throw new RuntimeException(e);
        }
    }
}

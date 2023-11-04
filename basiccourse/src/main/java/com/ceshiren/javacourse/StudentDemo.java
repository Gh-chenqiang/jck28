package com.ceshiren.javacourse;

import com.ceshiren.utils.MenuNumException;
import com.ceshiren.utils.SnuInputException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenqiang
 * @create 2023/11/4 21:31
 */
public class StudentDemo {
    public static void main(String[] args) throws MenuNumException {
        List<Student> students=new ArrayList<>();

        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"张三","男"));
        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"莉丝","女"));
        students.add(StudentManagement.addStudent(Integer.parseInt(StudentManagement.generate()),"王武","男"));

        System.out.println("添加的学员信息:");
        for(Student student:students){
            System.out.println(StudentManagement.appendStu(student));
        }

        StudentManagement.deleteStudentByName("莉丝", students);

        try {
            StudentSys.scannerStu(students);
        } catch (SnuInputException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.ceshiren.javacourse;

import com.ceshiren.Exception.InputIdException;
import com.ceshiren.Exception.InputSexException;
import com.ceshiren.Exception.NotExistException;

import java.util.Map;
import java.util.Optional;

/**
 * @Author chenqiang
 * @create 2023/11/5 21:38
 */
public interface StudentManagement {

    void initData();

    String generate();

    void addStudent(Integer snu, String name, String sex) throws InputIdException, InputSexException;

    void deleteStudentByName(String name , Map<Integer,Student> students) throws NotExistException;

    void deleteStudentBySnu(Integer sno , Map<Integer,Student> students) throws NotExistException;

    Optional queryStudent(Integer sno, Map<Integer,Student> students);
}

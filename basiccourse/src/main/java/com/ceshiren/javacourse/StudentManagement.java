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

    /**
     * 实例化学生
     */
    void initData();

    /**
     * 自动生成学号
     * @return
     */
    String generate();

    /**
     * 添加学员
     * @param snu
     * @param name
     * @param sex
     * @throws InputIdException
     * @throws InputSexException
     */
    void addStudent(Integer snu, String name, String sex,Map<Integer,Student> students) throws InputIdException, InputSexException;

    /**
     * 根据学员名字删除学员
     * @param name
     * @param students
     * @throws NotExistException
     */
    void deleteStudentByName(String name , Map<Integer,Student> students) throws NotExistException;

    /**
     * 根据学员学号删除学员
     * @param sno
     * @param students
     * @throws NotExistException
     */
    void deleteStudentBySnu(Integer sno , Map<Integer,Student> students) throws NotExistException;

    /**
     * 根据学号查找学员
     * @param sno
     * @param students
     * @return
     */
    Optional queryStudent(Integer sno, Map<Integer,Student> students);
}

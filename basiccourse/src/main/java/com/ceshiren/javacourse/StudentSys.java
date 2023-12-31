package com.ceshiren.javacourse;

import com.ceshiren.Exception.InputIdException;
import com.ceshiren.Exception.InputSexException;
import com.ceshiren.Exception.NotExistException;
import com.ceshiren.utils.StringOperate;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static com.ceshiren.enums.MenuEnum.*;

/**
 * @Author chenqiang
 * @create 2023/11/4 21:41
 */
public class StudentSys {
    private final StudentManagement studentManagement;

    public StudentSys(StudentManagement studentManagement) {
        // 通过接口进行实现
        this.studentManagement = studentManagement;
    }

    public void scannerStu(Map<Integer, Student> students) {

        // 控制台输入
        Scanner scanner = new Scanner(System.in);
        StringOperate stringOperate = new StringOperate();
        do {
            System.out.println(getMenu());
            System.out.println("请输入你的选择: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    // 查找学员信息
                    System.out.println(getPromptBySelect(select) + "请输入要查找的学员编号:");
                    String findNumber = scanner.nextLine();
                    if ("quit".equals(findNumber) || "exit".equals(findNumber)) {
                        break;
                    }
                    while (stringOperate.containsLetter(findNumber) || findNumber.isEmpty()) {
                        System.out.println("请输入要查找的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        findNumber = scanner.nextLine();
                        if ("quit".equals(findNumber) || "exit".equals(findNumber)) {
                            break;
                        }
                    }
                    if ("quit".equals(findNumber) || "exit".equals(findNumber)) {
                        break;
                    }
                    System.out.println("查找的学员信息:");
                    Optional student = studentManagement.queryStudent(Integer.parseInt(findNumber), students);
                    System.out.println(student);
                    break;
                case "2":
                    // 添加学员信息
                    System.out.println(getPromptBySelect(select) + "请输入学员编号:");
                    String addNumber = scanner.nextLine();
                    if ("quit".equals(addNumber) || "exit".equals(addNumber)) {
                        break;
                    }
                    while (stringOperate.containsLetter(addNumber) || addNumber.isEmpty()) {
                        System.out.println("请输入学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        addNumber = scanner.nextLine();
                        if ("quit".equals(addNumber) || "exit".equals(addNumber)) {
                            break;
                        }
                    }
                    if ("quit".equals(addNumber) || "exit".equals(addNumber)) {
                        break;
                    }
                    Integer num = Integer.parseInt(addNumber);
                    System.out.println("请输入学员姓名:");
                    String name = scanner.nextLine();
                    System.out.println("请输入学员姓别:");
                    String sex = scanner.nextLine();
                    try {
                        studentManagement.addStudent(num, name, sex, students);
                    } catch (InputIdException e) {
                        System.out.println("学员id已存在~");

                    } catch (InputSexException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    // 根据学员编号删除学员信息
                    System.out.println(getPromptBySelect(select) + "请输入要删除的学员编号:");
                    String delNumber = scanner.nextLine();
                    if ("quit".equals(delNumber) || "exit".equals(delNumber)) {
                        break;
                    }
                    while (stringOperate.containsLetter(delNumber) || delNumber.isEmpty()) {
                        System.out.println("请重新输入要删除的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        delNumber = scanner.nextLine();
                        if ("quit".equals(delNumber) || "exit".equals(delNumber)) {
                            break;
                        }
                    }
                    if ("quit".equals(delNumber) || "exit".equals(delNumber)) {
                        break;
                    }
                    try {
                        studentManagement.deleteStudentBySnu(Integer.parseInt(delNumber), students);
                    } catch (NotExistException e) {
                        System.out.println("系统不存在学员id信息~");
                    }
                    break;

                case "4":
                    // 退出学员系统
                    scanner.close();
                    System.out.println(getPromptBySelect(select));
                    return;
                default:
                    // 异常输入
                    System.out.println("请输入正确的菜单项选择!");
            }
        } while (true);
    }

}

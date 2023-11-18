package com.ceshiren.javacourse;

import com.ceshiren.Exception.InputIdException;
import com.ceshiren.Exception.InputSexException;
import com.ceshiren.Exception.NotExistException;
import com.ceshiren.utils.StringOperate;
import com.ceshiren.enums.MenuEnum;

import java.util.Map;
import java.util.Objects;
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
    public void scannerStu(Map<Integer,Student> students){
        /**
         * 控制台输入
         */
        Scanner scanner = new Scanner(System.in);
        StringOperate stringOperate = new StringOperate();
        boolean login = true;
        String str;
        do {
            System.out.println(getMenu());
            System.out.println("请输入你的选择: ");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    // 查找学员信息
                    System.out.println(getPromptBySelect(select) + "请输入要查找的学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(getPromptBySelect(select) + "请输入要查找的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        select = scanner.nextLine();
                        if ("quit".equals(select) || "exit".equals(select)) {
                            break;
                        }
                    }
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    System.out.println("查找的学员信息:");
                    Optional student = studentManagement.queryStudent(Integer.parseInt(select), students);
                    System.out.println(student);
                    break;
                case "2":
                    // 添加学员信息
                    System.out.println(getPromptBySelect(select) + "请输入学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(getPromptBySelect(select) + "请输入学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        select = scanner.nextLine();
                        if ("quit".equals(select) || "exit".equals(select)) {
                            break;
                        }
                    }
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    Integer num = Integer.parseInt(select);
                    System.out.println("请输入学员姓名:");
                    String name = scanner.nextLine();
                    System.out.println("请输入学员姓别:");
                    String sex = scanner.nextLine();
                    try {
                        studentManagement.addStudent(num, name, sex);
                    } catch (InputIdException e) {
                        System.out.println("学员id已存在~请输入学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");

                    } catch (InputSexException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("添加学员成功");
                    break;
                case "3":
                    // 根据学员编号删除学员信息
                    System.out.println(getPromptBySelect(select) + "请输入要删除的学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(getPromptBySelect(select) + "请重新输入要删除的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        select = scanner.nextLine();
                        if ("quit".equals(select) || "exit".equals(select)) {
                            break;
                        }
                    }
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    try {
                        studentManagement.deleteStudentBySnu(Integer.parseInt(select), students);
                    } catch (NotExistException e) {
                        System.out.println("系统不存在学员id信息~,请重新输入要删除的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                    }
                    break;

                case "4":
                    // 退出学员系统
                    scanner.close();
                    System.out.println(getPromptBySelect(select));
                    login = false;
                    break;
                default:
                    // 异常输入
                    System.out.println("请输入正确的菜单项选择!");
            }
        } while (login);
    }

}

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
        Scanner scanner = new Scanner(System.in);
        StringOperate stringOperate = new StringOperate();
        boolean login = true;
        while (login) {
            System.out.println(MenuEnum.getMenu());
            String select = scanner.nextLine();
            switch (Objects.requireNonNull(MenuEnum.getMenuBySelect(select))) {
                case SHOW:
                    System.out.println(MenuEnum.getMenuBySelect(select) + "请输入要查找的学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(MenuEnum.getMenuBySelect(select) + "请输入要查找的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
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
                case ADD:
                    System.out.println(MenuEnum.getMenuBySelect(select) + "请输入学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(MenuEnum.getMenuBySelect(select) + "请输入学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        select = scanner.nextLine();
                        if ("quit".equals(select) || "exit".equals(select)) {
                            break;
                        }
                    }
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    Integer num=Integer.parseInt(select);
                    System.out.println("请输入学员姓名:");
                    String name = scanner.nextLine();
                    System.out.println("请输入学员姓别:");
                    String sex = scanner.nextLine();
                    try {
                        studentManagement.addStudent(num,name,sex);
                    } catch (InputIdException e) {
                        System.out.println("学员id已存在~请输入学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");

                    } catch (InputSexException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("添加学员成功");
                    break;
                case DELETE:
                    System.out.println(MenuEnum.getMenuBySelect(select) + "请输入要删除的学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(MenuEnum.getMenuBySelect(select) + "请重新输入要删除的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
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
                case EXIT:
                    scanner.close();
                    System.out.println(MenuEnum.getMenuBySelect(select));
                    login = false;
                    break;
                default:
                    // 定义异常类Exception
                    System.out.println("请输入正确的菜单项选择!");
            }
        }
    }

}

package com.ceshiren.javacourse;

import com.ceshiren.utils.MenuNumException;
import com.ceshiren.utils.SnuInputException;
import com.ceshiren.utils.StringOperate;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @Author chenqiang
 * @create 2023/11/4 21:41
 */
public class StudentSys {
    public static void scannerStu(List<Student> students) throws MenuNumException, SnuInputException {

        Scanner scanner = new Scanner(System.in);
        String title = "--------欢迎来到学员信息管理系统--------\n";
        String selectOne = "根据学号查看学员信息\n";
        String selectTwo = "添加学员\n";
        String selectThree = "根据学号删除学员后，查看所有学员信息\n";
        String selectFour = "退出系统\n";
        StringOperate stringOperate = new StringOperate();
        boolean login = true;
        while (login) {
            System.out.println(title + "1 " + selectOne + "2 " + selectTwo + "3 " + selectThree + "4 " + selectFour + "请输入你的选择:");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    System.out.println(selectOne + "请输入要查找的学员编号:");
                    select = scanner.nextLine();
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    while (stringOperate.containsLetter(select) || select.isEmpty()) {
                        System.out.println(selectOne + "请输入要查找的学员编号(阿拉伯数字)或“quit” or “exit”返回菜单:");
                        select = scanner.nextLine();
                        if ("quit".equals(select) || "exit".equals(select)) {
                            break;
                        }
                    }
                    if ("quit".equals(select) || "exit".equals(select)) {
                        break;
                    }
                    System.out.println("查找的学员信息:");
                    Optional student = StudentManagement.queryStudent(Integer.parseInt(select), students);
                    System.out.println(student);
                    break;
                case "2":
                    Student student1 = new Student();
                    System.out.println(selectTwo + "请输入学员编号:");
                    select = scanner.nextLine();
                    if (stringOperate.containsLetter(select) || select.isEmpty()) {
                        throw new SnuInputException("请输入要查找的正确的学员编号!");
                    }
                    student1.setSnu(Integer.parseInt(select));
                    System.out.println("请输入学员姓名:");
                    select = scanner.nextLine();
                    student1.setName(select);
                    System.out.println("请输入学员姓别:");
                    select = scanner.nextLine();
                    student1.setSex(select);
                    students.add(StudentManagement.addStudent(student1.getSnu(), student1.getName(), student1.getSex()));
                    System.out.println("添加学员成功");
                    break;
                case "3":
                    System.out.println(selectThree + "请输入要删除的学员编号:");
                    select = scanner.nextLine();
                    if (stringOperate.containsLetter(select) || select.isEmpty()) {
                        throw new SnuInputException("请输入要删除的正确的学员编号!");
                    }
                    StudentManagement.deleteStudentBySnu(Integer.parseInt(select), students);
                    System.out.println("删除后的学员信息");
                    for (Student student2 : students) {
                        System.out.println(StudentManagement.appendStu(student2));
                    }
                    break;
                case "4":
                    scanner.close();
                    System.out.println(selectFour);
                    login = false;
                    break;
                default:
                    // 定义异常类Exception
                    throw new MenuNumException("请输入正确的菜单项选择!");


            }
        }
    }

}

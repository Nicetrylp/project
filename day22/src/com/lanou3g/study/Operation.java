package com.lanou3g.study;

import com.lanou3g.instrument.UserInstrument;

import java.sql.SQLException;
import java.util.Scanner;

public class Operation {
    private static final int QUERYALL = 1;
    private static final int QUERYUSEID = 2;
    private static final int ADDUSER = 3;
    private static final int DROPUSER = 4;
    private static final int UPDATEUSER = 5;
    public static void operation() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要执行的操作: ");
        System.out.println("1.查询所有用户的信息");
        System.out.println("2.根据id查询用户的信息");
        System.out.println("3.添加用户");
        System.out.println("4.删除用户");
        System.out.println("5.修改用户信息");
        int key = scanner.nextInt();
        scanner.nextLine();
        switch (key){
            case QUERYALL :
                UserInstrument.query();
                break;
            case QUERYUSEID:
                System.out.println("请输入要查询的ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                UserInstrument.query(id);
                break;
            case ADDUSER:
                System.out.println("请输入用户名:");
                String name = scanner.nextLine();
                System.out.println("请输入用户地址");
                String loc = scanner.nextLine();
                System.out.println("请输入用户年龄");
                int age = scanner.nextInt();
                scanner.nextLine();
                UserInstrument.add(name,loc,age);
                break;
            case DROPUSER:
                System.out.println("请输入要删除的用户名字:");
                String name2 = scanner.nextLine();
                UserInstrument.drop(name2);
                break;
            case UPDATEUSER :
                System.out.println("请输入要修改的用户的id");
                int id3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("请输入新的用户名");
                String name3 = scanner.nextLine();
                System.out.println("请输入新的地址");
                String locs = scanner.nextLine();
                System.out.println("请输入新的年龄");
                int age2 = scanner.nextInt();
                UserInstrument.update(name3,locs,age2,id3);
                break;
            default:
                break;
        }
    }
}

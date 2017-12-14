package nicetry.main;

import nicetry.classclass.User;
import nicetry.instrument.Look;
import nicetry.userdao.UserOperate;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Operate {

    private static Scanner scanner = new Scanner(System.in);

    private static User user = null;

    public static void start() throws DocumentException, IOException, InterruptedException, InstantiationException, IllegalAccessException {
        login();
        function();

    }

    private static void function() throws InterruptedException, IllegalAccessException, IOException, InstantiationException {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("请选择您要进行的操作:");
            System.out.println("1.查询天气\t2.查询手机号归属地\t3手速游戏\t4.查询手速游戏前十用户");
            int key = scanner.nextInt();
            scanner.nextLine();
            switch (key) {
                case 1:
                    System.out.println("请输入您的城市:");
                    String city = scanner.nextLine();
                    Look.weather(city);
                    break;
                case 2:
                    System.out.println("请输入您的手机号:");
                    String phoneNum = scanner.nextLine();
                    Look.location(phoneNum);
                    break;
                case 3:
                    Game game = new Game();
                    game.start(user);
                    break;
                case 4:
                    Look.ranking();
                    break;
                case 5:
                    isEnd = true;
                    break;
                default:
                    System.out.println("输入错误,请重新选择...");
                    break;
            }
        }
    }

    private static void login() throws DocumentException, IOException {
        System.out.println("欢迎来到Nice_try控制台");
        while (true) {
            System.out.println("1.登录\t\t2.注册");
            int key = scanner.nextInt();
            scanner.nextLine();
            if (key == 1){
                System.out.println("请输入您的用户名:");
                String userName = scanner.nextLine();
                System.out.println("请输入您的密码:");
                String password = scanner.nextLine();
                user = UserOperate.login(userName, password);
                if (user != null){
                    System.out.println(user.getName());
                    break;
                }else {
                    System.out.println("请重新登录...");
                }
            }else if (key == 2){
                System.out.println("请输入您的用户名:");
                String userName = scanner.nextLine();
                System.out.println("请输入您的密码:");
                String password = scanner.nextLine();
                System.out.println("请输入您的昵称:");
                String name = scanner.nextLine();
                UserOperate.register(new User(userName,password,name));
            }else {
                System.out.println("输入错误,请重新输入...");
            }

        }
    }
}

package nicetry.main;

import nicetry.classclass.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private int score;

    public int getScore() {
        return score;
    }

    public void start(User user) throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择游戏难度:");
        System.out.println("1.困难\t\t2.适中\t\t3.简单");
        int key = scanner.nextInt();
        scanner.nextLine();
        for (int i=3;i>0;i--) {
            System.out.println("倒计时" + i + "秒后游戏开始");
            Thread.sleep(1000);
        }
        System.out.println("游戏开始");
        String str;
        switch (key){
            case 1:
                str = hard();
                System.out.println(str);
                score = print(str);
                break;
            case 2:
                str = medium();
                System.out.println(str);
                score = print(str);
                break;
            case 3:
                str = easy();
                System.out.println(str);
                score = print(str);
                break;
            default:
                break;
        }
        System.out.println(user.getName() + ",您用的时间是" + score + "ms");
        upLoad(user);
    }

    private void upLoad(User user) throws IOException {
        URL url = new URL("http://192.168.20.221:8080/day16/insert?username=" +
                user.getName() +
                "&score=" +
                score);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024];
        int len = inputStream.read(buff);
        String string = new String(buff, 0, len,"utf-8");
        System.out.println(string);
    }

    private String hard(){
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            char c = (char)(new Random().nextInt(93)+33);
            str.append(c);
        }
        if (Pattern.matches(".*\\W+.*\\D+.*\\d+.*",str)){
            return new String(str);
        }
        return hard();
    }

    private String medium(){
        StringBuffer str = new StringBuffer();
        while (true){
            char c = (char)(new Random().nextInt(74)+48);
            if (Pattern.matches("[0-9a-zA-Z]",""+c))
            str.append(c);
            if (str.length() == 20){
                break;
            }
        }
        if (Pattern.matches(".*\\d+.*\\D+.*",str)){
            return new String(str);
        }
        return medium();
    }

    private String easy(){
        StringBuffer str = new StringBuffer();
        while (true){
            char c = (char)(new Random().nextInt(74)+48);
            if (Pattern.matches("[0-9a-z]",""+c))
            str.append(c);
            if (str.length() == 10){
                break;
            }
        }
        if (Pattern.matches(".*\\D+.*\\d+.*",str)){
            return new String(str);
        }
        return easy();
    }

    private int print(String str){
        int score;
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        String string;
        do {
            string = scanner.nextLine();
            if (str.equals(string))
                continue;
            System.out.println("您打错了,请重新输入");
        }while (!str.equals(string));
        long endTime = System.currentTimeMillis();
        score = (int) (endTime-startTime);
        return score;
    }

}

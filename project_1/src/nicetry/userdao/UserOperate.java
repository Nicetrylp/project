package nicetry.userdao;

import nicetry.classclass.User;
import nicetry.instrument.ReadWrite;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Map;

public class UserOperate {
    public static User login(String userName, String password) throws DocumentException {
        Map<String, User> map = ReadWrite.Read();
        User user = map.get(userName);
        if (user == null) {
            //throw new NotUserNameException();
            System.out.println("账号不存在");
            return null;
        }
        if (! password.equals(user.getPassword())){
//            throw new NotMatchUserNameAndPasswordException();
            System.out.println("账号与密码不匹配");
            return null;
        }
        System.out.println("登录成功");
        return user;
    }

    public static void register(User user) throws DocumentException, IOException {
//        Map<String, User> map1 = ReadWrite.Read();
//        User user1 = map1.get(user.getUserName());
        ReadWrite.Write(user);
        System.out.println("注册成功,请继续...");
    }
}

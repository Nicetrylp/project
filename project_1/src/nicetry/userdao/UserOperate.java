package nicetry.userdao;

import nicetry.bean.User;
import nicetry.exception.*;
import nicetry.instrument.DatabaseOperate;
import nicetry.instrument.ReadWrite;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Pattern;

public class UserOperate {
    public static User login(String userName, String password) throws DocumentException, LoginException, SQLException {
//        Map<String, User> map = ReadWrite.Read();
        Map<String, User> map = DatabaseOperate.read();

        User user = map.get(userName);
        if (user == null) {
            throw new UserNameNotFoundException();
        }
        if (! password.equals(user.getPassword())){
            throw new UserNameAndPasswordNotMatchException();
        }
        System.out.println("登录成功");
        return user;
    }

    public static void register(User user) throws DocumentException, IOException, RegisterException, SQLException {
//        Map<String, User> map1 = ReadWrite.Read();
        Map<String, User> map1 = DatabaseOperate.read();
        User user1 = map1.get(user.getUserName());
        if (user1 != null){
            // 用户名已存在
            throw new UserNameAlreadyExistException();
        }
        if (!(Pattern.matches("[1][3579]\\d{9}",user.getUserName())
        || (Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",user.getUserName()))
        )){
            // 用户名格式不对
            throw new UserNameFormatErrorException();
        }
        if (user.getPassword().length() < 6){
            throw new PasswordTooShortException();
        }
        if (user.getPassword().length()>14){
            throw new PasswordTooLongException();
        }
        if (!Pattern.matches(".*[a-z]+.*[A-Z]+.*\\d+.*"
                ,user.getPassword())){
            throw new PasswordNotSafetyException();
        }
//        ReadWrite.Write(user);
        DatabaseOperate.write(user);
        System.out.println("注册成功,请继续...");
    }
}

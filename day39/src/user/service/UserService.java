package user.service;

import user.bean.User;
import user.userdao.UserDao;

public class UserService {
    private static UserDao userDao = new UserDao();
    public boolean login(User user){
        User user1 = userDao.select(user.getUsername());
        System.out.println(user1);
        if (user1 == null || !user1.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;
    }
    public boolean register(User user){
        User user1 = userDao.select(user.getUsername());
        if (user1 != null){
            return false;
        }
        int i = userDao.insert(user);
        if (i == 1){
            return true;
        }
        return false;
    }
}

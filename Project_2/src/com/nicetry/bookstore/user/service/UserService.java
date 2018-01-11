package com.nicetry.bookstore.user.service;

import com.nicetry.bookstore.user.dao.UserDao;
import com.nicetry.bookstore.user.domain.User;
import com.nicetry.bookstore.user.service.exception.*;


public class UserService {
    UserDao userDao = new UserDao();
    public User login(User user) throws LoginException{
        if (!judge(user)){return null;}
        User dbUser = userDao.queryByName(user.getUsername());
        if (dbUser == null){
            //TODO 异常,用户名不存在
            throw new UsernameNotFoundException();
        }else if (!dbUser.getPassword().equals(user.getPassword())){
            throw new UsernameAndPasswordNotMatchException();
            //TODO 异常,用户名与密码不匹配
        }else if (!dbUser.isState()){
            //TODO 异常,该账户为激活
            throw new UsernameNotActivateException();
        }
        System.out.println("登录成功");
        return dbUser;
    }

    public void register(User user) throws RegisterException{
        if (!judge(user)){return;}

        User dbUser = userDao.queryByName(user.getUsername());
        if (dbUser != null){
            // TODO 异常,用户名已存在
            throw new UsernameAlreadyExistException();
        }else if (userDao.queryByEmail(user.getEmail()) != null){
            // 异常,邮箱已被注册
            throw new EmailAlreadyException();
        }else if (user.getPassword().length() <= 6){
            // TODO 异常,密码过短
            throw new PasswordIsTooShortException();
        }else if (user.getPassword().length() >18){
            // TODO 异常,密码过长
            throw new PasswordIsTooLongException();
        }
        // 全部满足后,插入
        user.setState(false);
        userDao.insertUser(user);
    }

    public void activate(String code) throws ActivateDefeatException {
        int i = userDao.updateStateByCode(code);
        if (i == 0){
            //TODO 激活失败
            throw new ActivateDefeatException();
        }
        if (i == 1){
            // 激活成功
            return;
        }
        System.out.println("出bug了");
    }

    /**
     *
     * 用来判断传入的用户是否为空
     * @param user
     * @return
     */
    private boolean judge(User user){
        if (user == null){
            System.out.println("user = null");
            return false;
        }
        return true;
    }

}

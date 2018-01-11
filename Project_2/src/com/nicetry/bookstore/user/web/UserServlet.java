package com.nicetry.bookstore.user.web;

import com.nicetry.bookstore.cart.domain.Cart;
import com.nicetry.bookstore.user.domain.User;
import com.nicetry.bookstore.user.service.UserService;
import com.nicetry.bookstore.user.service.exception.ActivateDefeatException;
import com.nicetry.bookstore.user.service.exception.LoginException;
import com.nicetry.bookstore.user.service.exception.RegisterException;
import com.nicetry.bookstore.util.BaseServlet;
import com.nicetry.bookstore.util.Email;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    UserService userService = new UserService();

    /**
     * 登录
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request , HttpServletResponse response){
        User user = initUser(request);
        try {
            user = userService.login(user);
        } catch (LoginException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/jsps/user/login.jsp";
        }
        request.getSession().setAttribute("uid",user.getUid());
        request.getSession().setAttribute("username",user.getUsername());
        request.getSession().setAttribute("cart",Cart.getCarMap());
        Cookie user1 = new Cookie("username",user.getUsername());
//        user1.setPath("/jsps/user/login.jsp");
        user1.setMaxAge(60*60*24*30); // 单位是s
        response.addCookie(user1);
        return "r:/jsps/main.jsp";
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request , HttpServletResponse response){
        User user = initUser(request);
        try {
            user.setUid(getUUID());
            user.setCode(user.getUid()+getUUID());
            userService.register(user);
        } catch (RegisterException e) {
            request.setAttribute("form",user);
            request.setAttribute("msg",e.getMessage());
            return "f:/jsps/user/regist.jsp";
        }
        try {
            request.setAttribute("code",user.getCode());
            Email.sendEmail(request);
            response.getWriter().write("注册成功,请通过邮箱激活");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 激活
     * @param request
     * @param response
     * @return
     */
    public String activate(HttpServletRequest request , HttpServletResponse response){
        try {
            userService.activate(request.getParameter("code"));
        } catch (ActivateDefeatException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/jsps/user/login.jsp";
        }
        request.getSession().setAttribute("msg","激活成功,请登录...");
        return "r:/jsps/user/login.jsp";
    }

    /**
     * 退出
     * @param request
     * @param response
     * @return
     */
    public String quit(HttpServletRequest request , HttpServletResponse response){
        request.getSession().removeAttribute("username");
        return "r:/jsps/main.jsp";
    }

    /**
     * 用来将request中的参数,保存到user中
     * @param request
     * @return
     */
    private User initUser(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 用来获得一个UUID
     * @return
     */
    private String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}

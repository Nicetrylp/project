package user.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import user.bean.User;
import user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private static UserService userService = new UserService();
    public String login(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        boolean login = userService.login(user);
        if (login){
            return "success";
        }
        return "error";
    }
    public String register(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        boolean register = userService.register(user);
        if (register){
            return "success";
        }
        return "error";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}

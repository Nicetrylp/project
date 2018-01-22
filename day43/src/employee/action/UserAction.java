package employee.action;

import com.opensymphony.xwork2.ActionSupport;
import employee.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport{
    private User user;

    public String login(){
        // 不用数据库了,直接登录
        System.out.println(user);
        if (user.getUsername().equals("123") && user.getPassword().equals("123")){
            ServletActionContext.getRequest().getSession().setAttribute("user",user);
            return SUCCESS;
        }
        addFieldError("login","用户名和密码不匹配");
        return ERROR;
    }

    @Override
    public void validate() {
        if (StringUtils.isBlank(user.getUsername())){
            // 没有输入用户名
            addFieldError("username","用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())){
            addFieldError("password","密码不能为空");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

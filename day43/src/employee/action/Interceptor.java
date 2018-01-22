package employee.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import employee.bean.User;
import org.apache.struts2.ServletActionContext;

public class Interceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user != null){
            return actionInvocation.invoke();
        }
        return "input";
    }
}

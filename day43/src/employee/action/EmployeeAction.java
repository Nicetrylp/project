package employee.action;

import com.opensymphony.xwork2.ActionSupport;
import employee.bean.Employee;
import employee.bean.User;
import employee.service.EmployeeService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class EmployeeAction extends ActionSupport {
    private Employee employee;
    private List<Employee> show;
    private static EmployeeService es = new EmployeeService();

    public String query(){
        return SUCCESS;
    }

    public String update(){
        es.update(employee);
        return SUCCESS;
    }

    public String show(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        System.out.println(user);
        this.show = es.show();
        ServletActionContext.getRequest().getSession().setAttribute("show",show);
        for (Employee employee1 : show) {
            System.out.println(employee1);
        }
        return SUCCESS;
    }

    public String redact(){
        System.out.println(employee);
        ServletActionContext.getRequest().getSession().setAttribute("employee",employee);
        return SUCCESS;
    }

    public String add(){
        es.add(employee);
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getShow() {
        return show;
    }

    public void setShow(List<Employee> show) {
        this.show = show;
    }
}

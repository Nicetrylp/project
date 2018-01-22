package employee.dao;

import com.lanou3g.util.HibernateUtil;
import employee.bean.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDao {
    public void add(Employee employee) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
//        System.out.println(employee);
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    public List<Employee> show() {
        List<Employee> handle = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from " + Employee.class.getName());
            List<Employee> list = query.list();
            return list;
        });
        return handle;
    }

    public void update(Employee employee) {
        System.out.println(employee);
        HibernateUtil.handle(session -> {
            session.update(employee);
            return null;
        });
    }
}

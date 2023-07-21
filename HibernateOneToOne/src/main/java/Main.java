import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.put(Environment.PASS,"demodemo!");
        properties.put(Environment.USER,"root");
        properties.put(Environment.URL,"jdbc:mysql://localhost:3306/demo");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Emp.class);
        configuration.addAnnotatedClass(Department.class);
     //   Department department = new Department();
       // department.setDeptName("Accounts");
        //Emp emp = new Emp();
        //emp.setName("Rohit");
        //emp.setDept(department);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Emp emp = session.get(Emp.class,1);
        System.out.println(emp);
        //session.persist(emp);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

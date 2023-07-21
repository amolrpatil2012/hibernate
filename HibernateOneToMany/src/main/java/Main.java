import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Student.class);
        List<Course>  courseList = new ArrayList<>();
        Course java = new Course();
        java.setCoursename("Java");
        Course python = new Course();
        python.setCoursename("Python");
        courseList.add(java);
        courseList.add(python);
        Student student = new Student();
        student.setName("Rohit");
        student.setCourseList(courseList);

        SessionFactory sessionFactory  = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}

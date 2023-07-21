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
        configuration.addAnnotatedClass(Book.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(new Book("Complete Java Ref"));
        session.persist(new Book("Complete Python Ref"));
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}

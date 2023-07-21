import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConf {

    private static SessionFactory sessionFactory;

    private HibernateConf(){}

    public static SessionFactory getSessionFactory()
    {
        if ( sessionFactory == null)
        {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.put(Environment.PASS,"demodemo!");
            properties.put(Environment.USER,"root");
            properties.put(Environment.URL,"jdbc:mysql://localhost:3306/demo");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            properties.put(Environment.SHOW_SQL,"true");

            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Student.class);
            sessionFactory = configuration.buildSessionFactory();

        }
        return  sessionFactory;
    }
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private SessionFactory factory = HibernateConf.getSessionFactory();

    @Override
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = factory.openSession())
        {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if(transaction!=null)
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = factory.openSession())
        {
            transaction = session.beginTransaction();
            student =  session.get(Student.class,id);
            //student = session.load(Student.class,id);
            //student = session.byId(Student.class).getReference(id);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if(transaction!=null)
            transaction.rollback();
            exception.printStackTrace();
        }
        return  student;
    }

    @Override
    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = factory.openSession())
        {
            transaction = session.beginTransaction();
            String sql = "from Student";
            students =  session.createQuery(sql).list();
            //student = session.load(Student.class,id);
            //student = session.byId(Student.class).getReference(id);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if(transaction!=null)
                transaction.rollback();
            exception.printStackTrace();
        }
        return  students;
    }

    @Override
    public void updateStudent(Student student) {

        Transaction transaction = null;
        try (Session session = factory.openSession())
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if(transaction!=null)
                transaction.rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession())
        {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class,id);
            session.delete(student);
            transaction.commit();
        }
        catch (Exception exception)
        {
            if(transaction!=null)
                transaction.rollback();
            exception.printStackTrace();
        }
    }
}

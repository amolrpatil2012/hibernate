import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);
    Student getStudentById ( int id );
    List<Student> getAllStudents();
    void updateStudent ( Student student);
    void deleteStudentById ( int id );

}

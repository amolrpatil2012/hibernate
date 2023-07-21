import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAOImpl studentDAO =new StudentDAOImpl();
        Scanner scanner = new Scanner(System.in);
        while ( true )
        {
            System.out.println("1. Insert 2. Display 3. Search By Id 4. Update 5. Delete");
            int option = scanner.nextInt();
            if ( option == 6)
                break;
            switch (option)
            {
                case 1: {
                    System.out.println("Enter Name");
                    String name = scanner.next();
                    System.out.println("Enter Email");
                    String email = scanner.next();
                    Student student = new Student();
                    student.setName(name);
                    student.setEmail(email);
                    studentDAO.saveStudent(student);
                    break;
                }
                case 2:
                    System.out.println(studentDAO.getAllStudents());
                    break;

                case 3: {
                    System.out.println("Enter Id");
                    int id = scanner.nextInt();
                    System.out.println(studentDAO.getStudentById(id));
                    break;
                }

                case 4: {
                    System.out.println("Enter Id");
                    int id = scanner.nextInt();
                    System.out.println("Enter Name");
                    String name = scanner.next();
                    System.out.println("Enter Email");
                    String email = scanner.next();
                    Student student = new Student();
                    student.setName(name);
                    student.setEmail(email);
                    student.setId(id);
                    studentDAO.updateStudent(student);
                    break;
                }
                case 5: {
                    System.out.println("Enter Id");
                    int id = scanner.nextInt();
                    studentDAO.deleteStudentById(id);
                    break;
                }
            }

        }
    }
}

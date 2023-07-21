import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @GeneratedValue
    int roll;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<Course> courseList ;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}

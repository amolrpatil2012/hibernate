import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_details")
public class Course {

    @Id
    @GeneratedValue
    int courseid;
    String coursename;

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                '}';
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}

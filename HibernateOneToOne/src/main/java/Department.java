import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int DeptId;
    String deptName;

    public Department() {
    }

    public Department(int deptId, String deptName) {
        DeptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return DeptId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DeptId=" + DeptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public void setDeptId(int deptId) {
        DeptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

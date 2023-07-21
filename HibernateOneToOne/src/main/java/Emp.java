import javax.persistence.*;

@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empId;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DeptId")
    Department dept;

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Emp() {
    }

    public Emp(int empId, String name, Department dept) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}

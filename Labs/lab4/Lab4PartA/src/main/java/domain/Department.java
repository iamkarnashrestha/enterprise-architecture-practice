package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    Department(){}
    @OneToMany(mappedBy = "department",cascade = {CascadeType.ALL}, fetch =FetchType.EAGER)
    private List<Employee> employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public Department(String name) {
        this.name = name;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}

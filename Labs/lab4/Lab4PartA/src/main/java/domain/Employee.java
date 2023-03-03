package domain;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int employeeNumber;
    Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department=department;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private String name;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

}

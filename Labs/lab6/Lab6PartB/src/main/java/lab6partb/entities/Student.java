package lab6partb.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private int studentNumber;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Department department;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private List<Grade> grades;
    public Student(){}



    public Student(int studentNumber, String name, Department department, List<Grade> grades) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.department = department;
        this.grades = grades;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}

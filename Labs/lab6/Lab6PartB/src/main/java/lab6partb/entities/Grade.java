package lab6partb.entities;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private String grade;
    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    public Grade(){}

    public Grade(String grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", course=" + course +
                '}';
    }
}

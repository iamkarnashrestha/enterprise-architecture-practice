package domain;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="school_id")
    @MapKey(name="studentId")
    private Map<Integer,Student> students;
    School(){}
    public School(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

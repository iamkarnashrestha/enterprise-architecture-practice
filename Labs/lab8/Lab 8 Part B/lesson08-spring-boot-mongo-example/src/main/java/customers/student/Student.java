package customers.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("students")
public class Student {
    @Id
    private String studentNumber;
    private  String name;
    private String phone;

    private Address address;

    private List<Grade> gradeList;

    public Student(String name, String phone, Address address, List<Grade> gradeList) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gradeList = gradeList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", gradeList=" + gradeList +
                '}';
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}

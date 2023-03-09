package lab6partb.repositories;

import lab6partb.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("Select stud from Student stud where stud.department.name=:departmentName")
    List<Student> findStudentByDepartmentName(String departmentName);

    @Query("Select stud from Student stud join stud.grades g where g.course.name=:courseName")
    List<Student> findStudentByCourseName(String courseName);
}

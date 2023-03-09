package customers.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {

    List<Student> findStudentsByName(String name);
    List<Student> findStudentsByPhone(String phone);
    @Query("{'address.city' : :#{#city}}")
    List<Student> findStudentsByCity(String city);

    @Query(("{ 'gradeList': { $elemMatch: { 'courseName' : :#{#courseName} } }}"))
    List<Student> findStudentsByCourseName(String courseName);

    @Query(("{ 'gradeList': { $elemMatch: { 'courseName' : :#{#courseName} , 'grade':'A+'} }}"))
    List<Student> findStudentsByCourseAndGrade(String courseName);
}

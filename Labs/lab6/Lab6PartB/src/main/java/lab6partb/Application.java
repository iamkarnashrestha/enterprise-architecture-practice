package lab6partb;

import lab6partb.entities.Course;
import lab6partb.entities.Department;
import lab6partb.entities.Grade;
import lab6partb.entities.Student;
import lab6partb.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Course EA=new Course("CSc544 Enterprise Architecture");
		Course MWA=new Course("Csc 545 Modern Web Programing");
		List<Grade> gradeList=new ArrayList<>();
		gradeList.add(new Grade("A",EA));
		gradeList.add(new Grade("A",MWA));

		Department compro=new Department("Compro");
		Student student=new Student(625216,"Karna Shrestha",compro,gradeList);
		studentRepository.save(student);

		System.out.println("================List of Students By Department==================");
		System.out.println(studentRepository.findStudentByDepartmentName("Compro"));

		System.out.println();
		System.out.println("================List of Students By Course Name========================");
		System.out.println(studentRepository.findStudentByCourseName("CSc544 Enterprise Architecture"));


	}
}

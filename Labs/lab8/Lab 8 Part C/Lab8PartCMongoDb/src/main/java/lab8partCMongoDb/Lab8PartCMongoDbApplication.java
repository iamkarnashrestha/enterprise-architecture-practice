package lab8partCMongoDb;


import lab8partCMongoDb.domain.Person;
import lab8partCMongoDb.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Lab8PartCMongoDbApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab8PartCMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addPersons();
		loadPersons();

	}
	//adding and saving persons
	public void addPersons(){
		StopWatch sw = new StopWatch();
		sw.start();
		for (int x=0; x< 10000; x++){
			personRepository.save( new Person("Karna"+x, "Shrestha"+x,addPets()));
		}
		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Total time to insert 10000 person records: "+totaltime+" ms");

	}

	//adding 10 pets
	public List<Pet> addPets(){
		List<Pet> pets=new ArrayList<>();
		for (int x=0; x< 10; x++){
			pets.add(new Pet("Pet", new Random().nextInt(10)));
		}
		return pets;
	}

	private void loadPersons() {
		StopWatch sw = new StopWatch();
		sw.start();
		personRepository.findAll();
		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Total time to retrive 10000 person records: "+totaltime+" ms");
	}

}

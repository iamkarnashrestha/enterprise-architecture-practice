package lab8partCMongoDb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Person {
@Id
    private String  id;
    private String firstName;
    private String lastName;

    List<Pet> pets;



    public Person(String firstName, String lastName, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }
}

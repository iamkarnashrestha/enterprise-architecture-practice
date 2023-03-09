package com.example.lab8partchsql;

import com.example.lab8partchsql.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}

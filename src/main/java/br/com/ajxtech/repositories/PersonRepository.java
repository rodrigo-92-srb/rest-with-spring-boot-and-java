package br.com.ajxtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ajxtech.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}

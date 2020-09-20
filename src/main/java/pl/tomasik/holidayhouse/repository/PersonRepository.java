package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomasik.holidayhouse.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}

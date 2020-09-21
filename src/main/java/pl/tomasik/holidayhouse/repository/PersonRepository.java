package pl.tomasik.holidayhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomasik.holidayhouse.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}

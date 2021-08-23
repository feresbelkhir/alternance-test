package Neopolis.TESTECHNIQUEALTERNANCE.Repository;

import Neopolis.TESTECHNIQUEALTERNANCE.Entity.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<person,Long> {
    Boolean existsByEmail(String Email);
}

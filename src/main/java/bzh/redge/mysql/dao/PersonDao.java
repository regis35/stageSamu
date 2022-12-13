package bzh.redge.mysql.dao;

import bzh.redge.mysql.data.Person;

import java.util.List;

public interface PersonDao {

    Person create(Person person);

    List<Person> findAll();

    Person findById(int id);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    void remove(int id);

}

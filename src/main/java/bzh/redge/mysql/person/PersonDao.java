package bzh.redge.mysql;

import java.util.List;

public interface PersonDao {

    Person create(Person person);

    List<Person> findAll();

    Person findById(int id);

    void remove(int id);

}

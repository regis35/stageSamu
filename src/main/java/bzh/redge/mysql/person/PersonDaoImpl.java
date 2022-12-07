package bzh.redge.mysql;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonDaoImpl implements PersonDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}

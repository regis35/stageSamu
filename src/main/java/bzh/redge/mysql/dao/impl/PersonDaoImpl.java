package bzh.redge.mysql.dao.impl;

import bzh.redge.mysql.dao.PersonDao;
import bzh.redge.mysql.data.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static bzh.redge.mysql.dao.impl.PersonnConstante.*;

@Repository
@AllArgsConstructor
@Slf4j
public class PersonDaoImpl implements PersonDao {

    private static final String INSERT_PERSON = "insert into " + TABLE_NAME + "("+FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + "," + FIELD_ADDRESS + "," + FIELD_CITY+") values (:firstName,:lastName,:address,:city)";
    private static final String SELECT_PERSON = "select " + FIELD_ID + "," + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + "," + FIELD_ADDRESS + "," + FIELD_CITY + " from " + TABLE_NAME;
    private static final String SELECT_PERSON_BY_ID = "select " + FIELD_ID + "," + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + "," + FIELD_ADDRESS + "," + FIELD_CITY + " from " + TABLE_NAME + " where " + FIELD_ID + " = :id";
    private static final String SELECT_PERSON_BY_FIRST_NAME_AND_LAST_NAME = "select " + FIELD_ID + "," + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + "," + FIELD_ADDRESS + "," + FIELD_CITY + " from " + TABLE_NAME + " where " + FIELD_FIRST_NAME + " = :firstName and " + FIELD_LAST_NAME + " = :lastName";
    private static final String DELETE_PERSON = "delete from " + TABLE_NAME + " where " + FIELD_ID + " = :id";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private PersonRowMapper rowMapper;

    @Override
    public Person create(Person person) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstName", person.getFirstName())
                .addValue("address", person.getAddress())
                .addValue("lastName", person.getLastName())
                .addValue("city", person.getCity());

        int nbRowAffected = namedParameterJdbcTemplate.update(INSERT_PERSON, parameters, holder);
        person.setId(holder.getKey().intValue());
        return person;
    }

    @Override
    public List<Person> findAll() {
        return namedParameterJdbcTemplate.query(SELECT_PERSON, rowMapper);
    }

    @Override
    public Person findById(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        try {
            return (Person) namedParameterJdbcTemplate.queryForObject(SELECT_PERSON_BY_ID, parameters, rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstName", firstName)
                .addValue("lastName", lastName);

        try {
            return (Person) namedParameterJdbcTemplate.queryForObject(SELECT_PERSON_BY_FIRST_NAME_AND_LAST_NAME, parameters, rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public void remove(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        int nbRowAffected = namedParameterJdbcTemplate.update(DELETE_PERSON, parameters);
        if (nbRowAffected == 0) {
            log.warn("Person with id '{}' not deleted", id);
        }
    }
}

package bzh.redge.mysql;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitBdd {

    private static String CREATE_TABLE_PERSON = "CREATE TABLE IF NOT EXISTS Persons (" +
            "    PersonID int," +
            "    LastName varchar(255)," +
            "    FirstName varchar(255)," +
            "    Address varchar(255)," +
            "    City varchar(255)" +
            ");";

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {

        jdbcTemplate.execute(CREATE_TABLE_PERSON);

    }

}

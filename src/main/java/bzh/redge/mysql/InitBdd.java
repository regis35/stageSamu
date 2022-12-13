package bzh.redge.mysql;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitBdd {

    private static String CREATE_TABLE_PERSON = "CREATE TABLE IF NOT EXISTS Persons (" +
            "    personId bigint NOT NULL AUTO_INCREMENT," +
            "    lastName varchar(255)," +
            "    firstName varchar(255)," +
            "    address varchar(255)," +
            "    city varchar(255)," +
            "    PRIMARY KEY (personId) "+
            ");";

    private static String CREATE_TABLE_IMAGE = "CREATE TABLE IF NOT EXISTS Images (" +
            "    fileId bigint NOT NULL AUTO_INCREMENT," +
            "    file LONGBLOB," +
            "    personIdFK bigint," +
            "    PRIMARY KEY (fileId), "+
            "    FOREIGN KEY (personIdFK) REFERENCES Persons(PersonID)"+
            ");";

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {

        jdbcTemplate.execute(CREATE_TABLE_PERSON);
        jdbcTemplate.execute(CREATE_TABLE_IMAGE);

    }

}

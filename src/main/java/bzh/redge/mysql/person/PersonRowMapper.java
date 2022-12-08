package bzh.redge.mysql.person;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Person.builder().id(rs.getInt("contact_id"))
                .firstName(rs.getString("name"))
                .lastName(rs.getString("name"))
                .address(rs.getString("name"))
                .city(rs.getString("name"))
                .build();
    }
}

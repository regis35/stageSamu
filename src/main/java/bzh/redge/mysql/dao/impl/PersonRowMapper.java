package bzh.redge.mysql.dao.impl;


import bzh.redge.mysql.data.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static bzh.redge.mysql.dao.impl.PersonnConstante.*;

@Component
public class PersonRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Person.builder().id(rs.getInt(FIELD_ID))
                .firstName(rs.getString(FIELD_FIRST_NAME))
                .lastName(rs.getString(FIELD_LAST_NAME))
                .address(rs.getString(FIELD_ADDRESS))
                .city(rs.getString(FIELD_CITY))
                .build();
    }
}

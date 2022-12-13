package bzh.redge.mysql.dao.impl;


import bzh.redge.mysql.data.Image;
import bzh.redge.mysql.data.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static bzh.redge.mysql.dao.impl.PersonnConstante.*;

@Component
public class ImageRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Image.builder().id(rs.getInt("fileId"))
                .content(rs.getBytes("content"))
                .build();
    }
}

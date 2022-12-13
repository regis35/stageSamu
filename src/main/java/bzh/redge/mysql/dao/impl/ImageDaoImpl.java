package bzh.redge.mysql.dao.impl;

import bzh.redge.mysql.dao.ImageDao;
import bzh.redge.mysql.dao.data.ImageDataJdbc;
import bzh.redge.mysql.data.Image;
import bzh.redge.mysql.data.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class ImageDaoImpl implements ImageDao {

    private static final String INSERT = "insert into Images (file, personIdFK) values (:content, :personId)";

    private static final String SELECT  = "select fileId, content from Images where personId = :personId";
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Image create(Image image) {
        try {
            /** traitement pouvant être fait par un mapper */
            Blob blob = new SerialBlob(image.getContent());
            ImageDataJdbc data = ImageDataJdbc.builder()
                    .content(blob)
                    .personId(image.getPerson().getId())
                    .build();
            /** fin mapper */

            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue("content", data.getContent())
                    .addValue("personId", data.getPersonId());

            int nbRowAffected = namedParameterJdbcTemplate.update(INSERT, parameters, holder);
            image.setId(holder.getKey().intValue());
            return image;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> findByPerson(Person person) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("personId", person.getId());

        return (Person) namedParameterJdbcTemplate.queryForList(SELECT, parameters, new ImageRowMapper());
        namedParameterJdbcTemplate.query()

        return null;
    }
}

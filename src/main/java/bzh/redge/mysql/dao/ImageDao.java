package bzh.redge.mysql.dao;

import bzh.redge.mysql.data.Image;
import bzh.redge.mysql.data.Person;

import java.util.List;

public interface ImageDao {

    Image create(Image image);

    List<Image> findByPerson(Person person);
}

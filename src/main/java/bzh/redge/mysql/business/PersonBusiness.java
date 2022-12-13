package bzh.redge.mysql.business;

import bzh.redge.mysql.dao.ImageDao;
import bzh.redge.mysql.data.Image;
import bzh.redge.mysql.data.Person;
import bzh.redge.mysql.dao.PersonDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class PersonBusiness {

    private PersonDao personDao;
    private ImageDao imageDao;
    public void addID(Person person, Image image){
        log.info("[addID] check if person is in the storage");
        Person personFind = personDao.findById(person.getId());
        if (personFind == null) {
            log.info("[addID] user is not found");
            throw new RuntimeException("user is not found");
        }

        image.setPerson(personFind);
        imageDao.create(image);

        log.info("[addID] start");
    }

    public Person loadIDs(Person person) {
        log.info("[loadIDs] check if person is in the storage");
        Person personFind = personDao.findById(person.getId());
        if (personFind == null) {
            log.info("[loadIDs] user is not found");
            throw new RuntimeException("user is not found");
        }
        List<Image> images = imageDao.findByPerson(personFind);
        person.setImages(images);

        return person;
    }

    public Person addNewPerson(Person person) {
        log.info("[add] add new person");
        Person personFind = personDao.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (personFind != null) {
            log.info("[add] person with firstName '{}' and lastName '{}' is already exist", person.getFirstName(), person.getLastName());
            return personFind;
        }
        log.info("[add] person with firstName '{}' and lastName '{}' not found", person.getFirstName(), person.getLastName());
        return personDao.create(person);
    }

    public List<Person> findAll() {
        log.info("[findAll] start");
        try {
            return personDao.findAll();
        } finally {
            log.info("[findAll] end");
        }
    }

    public void deletePerson(Person person) {
        log.info("[deletePerson] check if person is in the storage");
        Person personFind = personDao.findById(person.getId());
        if (personFind != null) {
            log.info("[deletePerson] remove person");
            personDao.remove(person.getId());
        }
        log.info("[deletePerson] end");
    }

}

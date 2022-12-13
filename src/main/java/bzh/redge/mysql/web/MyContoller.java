package bzh.redge.mysql.web;

import bzh.redge.mysql.data.Image;
import bzh.redge.mysql.data.Person;
import bzh.redge.mysql.business.PersonBusiness;
import bzh.redge.mysql.web.request.PersonCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MyContoller {

    private PersonBusiness personBusiness;

    @GetMapping(value = "/person")
    public List<Person> getAllPerson() {
        return personBusiness.findAll();
    }

    @PostMapping(value = "/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody PersonCreateRequest personRequest) {

        Person person = Person.builder()
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .address(personRequest.getAddress())
                .city(personRequest.getCity())
                .build();

        return personBusiness.addNewPerson(person);
    }

    @DeleteMapping(value = "/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {

        Person person = Person.builder()
                .id(id)
                .build();

        personBusiness.deletePerson(person);
    }

    @PostMapping("/person/{id}/image")
    @ResponseStatus(HttpStatus.CREATED)
    public void handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable("id") int id) {
        try {
            Image image = Image.builder().content(file.getBytes()).build();
            Person person = Person.builder()
                    .id(id)
                    .build();

            personBusiness.addID(person, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/person/{id}/image")
    @ResponseStatus(HttpStatus.OK)
    public Person getImages(@PathVariable("id") int id) {
        Person person = Person.builder()
                .id(id)
                .build();
        return personBusiness.loadIDs(person);
    }
}

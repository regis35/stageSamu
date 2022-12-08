package bzh.redge.mysql.person;

import lombok.Builder;

@Builder
public class Person {

    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

}

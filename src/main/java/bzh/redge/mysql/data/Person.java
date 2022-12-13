package bzh.redge.mysql.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class Person {

    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private List<Image> images;

}

package bzh.redge.mysql.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PersonCreateRequest {

    private String lastName;
    private String firstName;
    private String address;
    private String city;

}

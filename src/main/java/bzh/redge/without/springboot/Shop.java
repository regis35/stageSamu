package bzh.redge.without.springboot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class Shop {

    private UUID id;
    private String name;
    private String address;

}

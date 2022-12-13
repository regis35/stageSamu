package bzh.redge.mysql.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Image {

    private int id;
    private byte[] content;
    private Person person;
}

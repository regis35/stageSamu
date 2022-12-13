package bzh.redge.mysql.dao.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Setter
@Getter
@Builder
public class ImageDataJdbc {

    private int id;
    private int personId;
    private Blob content;

}

package bzh.redge.mysql;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyContoller {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @GetMapping(name = "/hello")
    public String hello() {

        return "hello";
    }

}

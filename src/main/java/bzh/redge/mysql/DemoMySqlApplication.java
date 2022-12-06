package bzh.redge.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class DemoMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMySqlApplication.class, args);
    }
}

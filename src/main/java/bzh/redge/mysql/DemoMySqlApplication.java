package bzh.redge.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@AutoConfiguration
public class DemoMySqlApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoMySqlApplication.class, args);




    }
}

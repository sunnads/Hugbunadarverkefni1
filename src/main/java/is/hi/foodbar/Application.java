package is.hi.foodbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * The main class of the project.
 * By running the main class of {@link Application} then you start the Spring Boot system
 *
 * @author Elvar Kjartansson, elk11@hi.is
 * @date September 2017
 * @version 1.0
 * HBV501G Hugbúnarverkefni 1 Háskóli Íslands
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
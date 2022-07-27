package PP_3_1_1_CRUDSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EnableJpaRepositories("PP_3_1_1_CRUDSpringBoot")
@EntityScan("PP_3_1_1_CRUDSpringBoot")
public class Pp311CrudSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pp311CrudSpringBootApplication.class, args);
	}

}

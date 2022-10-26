package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class S04T02N03PedroCasullaJoanMarcApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03PedroCasullaJoanMarcApplication.class, args);
	}

}

package config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppConfig implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);

	}
	
	
	@Bean
	public JogoService getJogoService(){
		return  new DefaultJogoService();
	}

	@Override
	public void run(String... args) throws Exception {
	    getJogoService().jogo();
		
	}	

}

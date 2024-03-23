package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import common.Coach;
import common.SwimCoach;

@Configuration
public class SportConfig {

	//define the bean method to configure the bean
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}

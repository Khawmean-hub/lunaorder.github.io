package com.kosign.luna;

import com.kosign.luna.property.FileStorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class LunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunaApplication.class, args);
	}

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

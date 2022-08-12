package br.com.natan.api.config;

import br.com.natan.api.domain.User;
import br.com.natan.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDb(){
        User u1 = new User(null, "Valdir", "valdir@mail.com", "123456");
        User u2 = new User(null, "Natan", "natan@mail.com", "123456");

        repository.saveAll(List.of(u1,u2));
    }

}

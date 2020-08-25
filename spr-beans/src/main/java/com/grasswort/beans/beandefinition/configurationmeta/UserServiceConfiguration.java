package com.grasswort.beans.beandefinition.configurationmeta;

import com.grasswort.beans.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Collection;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/25
 */
@Configuration
@Import(UsersConfiguration.class)
public class UserServiceConfiguration {

    @Bean
    public IdGenerator idGenerator() {
        return new UserIdGenerator();
    }

    @Bean
    public UserRepository userRepository(IdGenerator idGenerator) {
        UserRepository userRepository = new UserRepository();
        userRepository.setIdGenerator(idGenerator);
        return userRepository;
    }

    @Bean
    public UserService userService(UserRepository userRepository, Collection<User> users) {
        UserService userService = new UserService(userRepository);
        users.forEach(userService::addUser);
        return userService;
    }
}

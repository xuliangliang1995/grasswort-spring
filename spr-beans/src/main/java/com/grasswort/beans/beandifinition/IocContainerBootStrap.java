package com.grasswort.beans.beandifinition;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/5
 */
public class IocContainerBootStrap {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition userRepositoryBd = BeanDefinitionBuilder.genericBeanDefinition(UserRepository.class)
                .addAutowiredProperty("idGenerator")
                .getBeanDefinition();

        BeanDefinition userServiceBd = BeanDefinitionBuilder.genericBeanDefinition(UserService.class)
                .addConstructorArgReference("userRepository")
                .getBeanDefinition();

        beanFactory.registerSingleton("userIdGenerator", new UserIdGenerator());
        beanFactory.registerBeanDefinition("userRepository", userRepositoryBd);
        beanFactory.registerBeanDefinition("userService", userServiceBd);

        UserService userService = beanFactory.getBean("userService", UserService.class);

        Stream.of(new User("Jerry", 8), new User("Tom", 18))
                .forEach(userService::addUser);

        userService.listUser().stream().forEach(System.out::println);
    }

}

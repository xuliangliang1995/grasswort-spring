package com.grasswort.beans.beandefinition;

import com.grasswort.beans.model.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/5
 */
public class GenericBeanDefinitionTest {

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

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof UserService) {
                    return UserServiceProxy.getInstance((IUserService) bean);
                }
                return bean;
            }
        });

        IUserService userService = beanFactory.getBean("userService", IUserService.class);

        Stream.of(new User("Jerry", 8), new User("Tom", 18))
                .forEach(userService::addUser);

        userService.listUser().stream().forEach(System.out::println);
    }

}

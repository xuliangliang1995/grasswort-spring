package com.grasswort.beans.beandefinition.reader;

import com.grasswort.beans.model.User;
import com.grasswort.beans.model.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/25
 */
public class AnnotationBasedConfigurationTest {

    private static Logger logger = LoggerFactory.getLogger(AnnotationBasedConfigurationTest.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "com/grasswort/beans/beandefinition/configurationmeta/user-service-annotation-based.xml"
        );
        logger.info("已解析 BeanDefinition 数量 : {}", applicationContext.getBeanDefinitionCount());

        Stream.of(applicationContext.getBeanDefinitionNames())
                .forEach(System.out::println);

        BeanDefinition userServiceBeanDefinition = applicationContext.getBeanFactory()
                .getBeanDefinition("userService");
        // 注意,这里的 BeanDefinition 的 ConstructorArgumentValues 为 null
        logger.info("UserServiceBeanDefinition [ConstructorArgumentValues]: {}",
                userServiceBeanDefinition.getConstructorArgumentValues().getArgumentCount());

        UserService userService = applicationContext.getBean(UserService.class);
        applicationContext.getBeansOfType(User.class).values().forEach(userService::addUser);
        userService.listUser().forEach(System.out::println);
    }
}

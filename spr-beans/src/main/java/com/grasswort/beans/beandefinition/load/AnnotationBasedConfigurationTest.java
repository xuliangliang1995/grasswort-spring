package com.grasswort.beans.beandefinition.load;

import com.grasswort.beans.model.User;
import com.grasswort.beans.model.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/25
 */
public class AnnotationBasedConfigurationTest {

    private static Logger logger = LoggerFactory.getLogger(AnnotationBasedConfigurationTest.class);

    public static void main(String[] args) {
        // DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        GenericApplicationContext beanFactory = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        int loadCount = xmlBeanDefinitionReader.loadBeanDefinitions("com/grasswort/beans/beandefinition/configurationmeta/user-service-annotation-based.xml");
        logger.info("已解析 BeanDefinition 数量 : {}", loadCount);

        Stream.of(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);

        beanFactory.refresh();

        UserService userService = beanFactory.getBean(UserService.class);
        beanFactory.getBeansOfType(User.class).values().forEach(userService::addUser);
        userService.listUser().forEach(System.out::println);
    }

}

package com.grasswort.beans.beandefinition.reader;

import com.grasswort.beans.beandefinition.configurationmeta.UserConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/13
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor
 * @see org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader
 */
public class AnnotationIocContainerTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfiguration.class);
        context.refresh(); // can't get the BeanDefinition named tom if not refresh
        // this step will register a {@link ConfigurationClassPostProcessor} bean ,
        // it will invoke the {@link ConfigurationClassBeanDefinitionReader} to resolve inner bean.
        Stream.of(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        BeanDefinition userConfigurationBd = context.getBeanDefinition("userConfiguration");
        System.out.println(userConfigurationBd.getAttribute("org.springframework.context.annotation.ConfigurationClassPostProcessor.configurationClass"));

        BeanDefinition beanDefinition = context.getBeanDefinition("tom");
        System.out.println(beanDefinition);
    }
}

package com.grasswort.beans;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/7/23
 */
public class BeanDefinitionTest {

    public static void main(String[] args) {
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("name", "xuliang")
                .addPropertyValue("age", 18)
                .addAutowiredProperty("child")
                .setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME)
                .getBeanDefinition();
        System.out.println("自定义 BeanDefinition：" + beanDefinition);

        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        beanDefinitionRegistry.registerBeanDefinition("user", beanDefinition);


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        String[] beanDefinitionNames = beanDefinitionRegistry.getBeanDefinitionNames();
        System.out.println("已注册 BeanDefinition：" + Stream.of(beanDefinitionNames)
                .map(String::valueOf)
                .reduce("", (a, b) -> a + " " + b));
    }

    class User {
        private String name;
        private Integer age;
        private User child;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public User getChild() {
            return child;
        }

        public void setChild(User child) {
            this.child = child;
        }
    }
}

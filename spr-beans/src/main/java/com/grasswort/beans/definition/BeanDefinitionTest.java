package com.grasswort.beans.definition;

import com.grasswort.beans.definition.model.IDCard;
import com.grasswort.beans.definition.model.Student;
import com.grasswort.beans.definition.model.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
public class GenericBeanDefinitionTest {

    public static void main(String[] args) {
        //BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        registerGenericBeanDefinition(beanFactory);
        registerRootChildBeanDefinition(beanFactory);

        System.out.println("已注册 BeanDefinition :");
        Stream.of(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);

        Student xiaoMing = beanFactory.getBean("xiaoMing", Student.class);
        System.out.println(xiaoMing);

        Student tom = beanFactory.getBean("tom", Student.class);
        System.out.println(tom);
    }

    public static void registerRootChildBeanDefinition(BeanDefinitionRegistry registry) {
        BeanDefinition user = BeanDefinitionBuilder.rootBeanDefinition(User.class)
                .addPropertyValue("name", "Tom")
                .addPropertyValue("age", 16)
                .getBeanDefinition();
        registry.registerBeanDefinition("userRoot", user);

        BeanDefinition tom = BeanDefinitionBuilder.childBeanDefinition("userRoot")
                .addPropertyReference("idCard", "idCard")
                .getBeanDefinition();
        tom.setBeanClassName(Student.class.getCanonicalName());

        registry.registerBeanDefinition("tom", tom);

    }

    public static void registerGenericBeanDefinition(BeanDefinitionRegistry registry) {
        BeanDefinition user = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("name", "小明")
                .addPropertyValue("age", 18)
                .getBeanDefinition();
        registry.registerBeanDefinition("user", user);

        BeanDefinition idCard = BeanDefinitionBuilder.genericBeanDefinition(IDCard.class)
                .addPropertyValue("idNumber", "***********1111")
                .getBeanDefinition();
        registry.registerBeanDefinition("idCard", idCard);

        BeanDefinition xiaoMing = BeanDefinitionBuilder.genericBeanDefinition(Student.class)
                .setParentName("user")
                .addPropertyReference("idCard", "idCard")
                .getBeanDefinition();

        registry.registerBeanDefinition("xiaoMing", xiaoMing);


    }
}

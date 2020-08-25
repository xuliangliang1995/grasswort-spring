package com.grasswort.beans.beandefinition.reader;

import com.grasswort.beans.model.User;
import com.grasswort.beans.model.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/9
 */
public class XmlBeanDefinitionConfigurationTest {

    private static Logger logger = LoggerFactory.getLogger(XmlBeanDefinitionConfigurationTest.class);

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        int loadCount = xmlBeanDefinitionReader.loadBeanDefinitions(
                "com/grasswort/beans/beandefinition/configurationmeta/user-service.xml");

        logger.info("已解析 BeanDefinition 数量 : {}", loadCount);

        Stream.of(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);
    }


    private static void resolveAnnotationBasedConfigurationMetadata() {

    }
}

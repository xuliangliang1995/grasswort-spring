package com.grasswort.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/7/27
 */
public class BeanDefinitionTestV2 {

    public static void main(String[] args) {
        testBeanDefinition();
    }

    private static void testBeanDefinition() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition descBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Descriptor.class)
                .addPropertyValue("desc", "Hi , I am Spring .")
                .getBeanDefinition();

        BeanDefinition testBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(TestBean.class)
                .addPropertyValue("name", "xuliang")
                .addAutowiredProperty("desc")
                .getBeanDefinition();

        beanFactory.registerBeanDefinition("descBean", descBeanDefinition);
        beanFactory.registerBeanDefinition("testBean",  testBeanDefinition);

        TestBean testBean = beanFactory.getBean(TestBean.class);

        System.out.println(testBean.getName());
        System.out.println(testBean.getDesc().getDesc());

        System.out.println(testBean != null);
    }




    static class TestBean {

        public TestBean() {
            System.out.println("invoke constructor .");
        }

        private String name;
        private Descriptor desc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Descriptor getDesc() {
            return desc;
        }

        public void setDesc(Descriptor desc) {
            this.desc = desc;
        }
    }

    static class Descriptor {
        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}

package com.grasswort.beans.beans.create;

import com.grasswort.beans.beans.IocContainer;
import com.grasswort.beans.model.UserRepository;
import org.springframework.beans.factory.BeanFactory;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/28
 */
public class UserRepositoryCreateTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = IocContainer.start();
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        System.out.println(userRepository);
    }
}

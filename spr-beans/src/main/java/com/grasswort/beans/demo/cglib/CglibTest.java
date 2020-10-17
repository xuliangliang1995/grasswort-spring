package com.grasswort.beans.demo.cglib;

import com.grasswort.beans.model.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xuliang
 * @Date 2020/9/21
 * @Description
 */
public class CglibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setUseCache(false);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, methodProxy) -> {
            System.out.println("pre processor");
            return methodProxy.invokeSuper(obj, args1);
        });
        Object userProxyInstance = enhancer.create();
        System.out.println(User.class.isAssignableFrom(userProxyInstance.getClass()));
        ((User) userProxyInstance).setName("jerry");
        System.out.println(userProxyInstance);
    }
}

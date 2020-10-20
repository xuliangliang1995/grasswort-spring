package com.grasswort.beans.demo.cglib;

import com.grasswort.beans.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author xuliang
 * @Date 2020/9/21
 * @Description
 */
public class ProxyTest {

    public static void main(String[] args) {
        testAspectJProxyFactory();
        testEnhancer();
    }

    private static void testAspectJProxyFactory() {
        User user = new User();
        user.setName("jerry");
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(user);
        proxyFactory.addAspect(UserAspect.class);
        User userProxy = proxyFactory.getProxy();
        System.out.println(userProxy.getName());
    }

    private static void testEnhancer() {
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

    @Aspect
    public static class UserAspect {

        @Pointcut("execution(public String com.grasswort.beans.model.User.getName())")
        public void preGetName() {}

        @Before("preGetName()")
        public void preGetNameAdvice(JoinPoint jp) {
            System.out.println("pre getName ...");
        }

    }

}

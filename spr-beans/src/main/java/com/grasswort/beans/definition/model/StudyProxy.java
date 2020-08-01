package com.grasswort.beans.definition.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
public class StudyProxy implements InvocationHandler {

    private IStudy study;

    public IStudy getInstance(IStudy study) {
        this.study = study;
        Class clazz = study.getClass();
        return (IStudy)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("study")) {
            System.out.println("(mmp, 学个球, 我想玩耍 !)");
        }
        method.invoke(study, args);
        return null;
    }

}

package com.grasswort.beans;

import sun.reflect.generics.factory.CoreReflectionFactory;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.repository.MethodRepository;
import sun.reflect.generics.scope.MethodScope;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/7/27
 */
public class GenericTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericTest.class.getDeclaredMethod("test");
        Type type = method.getGenericReturnType();

        ParameterizedType parameterizedType = (ParameterizedType) type;
        Stream.of(parameterizedType.getActualTypeArguments())
                .forEach(System.out::println);
    }

    public List<String> test() {
        return null;
    }
}

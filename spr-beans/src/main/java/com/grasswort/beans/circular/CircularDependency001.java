package com.grasswort.beans.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/9/17
 */
@Component
public class CircularDependency001 {

    @Autowired
    @Lazy
    private CircularDependency002 circularDependency002;
}

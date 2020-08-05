package com.grasswort.beans.definition;

import com.grasswort.beans.definition.model.IStudy;
import com.grasswort.beans.definition.model.Student;
import com.grasswort.beans.definition.model.StudyProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
public class JerryBeanPostProcessor implements BeanPostProcessor {

    /**
     * Apply this {@code BeanPostProcessor} to the given new bean instance <i>before</i> any bean
     * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
     * or a custom init-method). The bean will already be populated with property values.
     * The returned bean instance may be a wrapper around the original.
     * <p>The default implementation returns the given {@code bean} as-is.
     *
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one;
     * if {@code null}, no subsequent BeanPostProcessors will be invoked
     * @throws BeansException in case of errors
     * @see InitializingBean#afterPropertiesSet
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student && "jerry".equals(beanName)) {
            return new StudyProxy().getInstance((Student) bean);
        }
        return bean;
    }
}

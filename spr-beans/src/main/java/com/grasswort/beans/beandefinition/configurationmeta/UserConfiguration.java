package com.grasswort.beans.beandefinition.configurationmeta;

import com.grasswort.beans.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/13
 */
@Configuration
public class UserConfiguration {

    @Bean
    public User tom() {
        User tom = new User();
        tom.setId(1L);
        tom.setAge(18);
        tom.setName("Tom");
        return tom;
    }
}

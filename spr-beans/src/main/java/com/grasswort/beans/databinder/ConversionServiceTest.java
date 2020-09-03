package com.grasswort.beans.databinder;

import com.grasswort.beans.model.User;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;
import java.util.stream.Stream;

public class ConversionServiceTest {

    public static void main(String[] args) {
        String text = "1-tom-18";
        User user = new CustomConverter().convert(text);
        System.out.println(user);

        Object object = new CustomGenericConverter()
                .convert(text, TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(User.class));
        System.out.println(object);
    }

    public static class CustomConverter implements Converter<String, User> {
        @Override
        public User convert(String source) {
            String[] args = source.split("-");
            User user = new User();
            user.setId(Long.valueOf(args[0]));
            user.setName(args[1]);
            user.setAge(Integer.valueOf(args[2]));
            return user;
        }
    }

    public static class CustomGenericConverter implements GenericConverter {

        @Override
        public Set<ConvertiblePair> getConvertibleTypes() {
            return Set.of(new ConvertiblePair(String.class, User.class));
        }

        @Override
        public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
            if (source instanceof String) {
                String[] args = ((String) source).split("-");
                User user = new User();
                user.setId(Long.valueOf(args[0]));
                user.setName(args[1]);
                user.setAge(Integer.valueOf(args[2]));
                return user;
            }
            return null;
        }
    }
}

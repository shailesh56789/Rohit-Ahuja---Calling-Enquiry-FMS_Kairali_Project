package com.Kairali.Rohit.Ahuja.Calling.Enquiry.listener;

import com.Kairali.Rohit.Ahuja.Calling.Enquiry.annotation.AutoTrim;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.lang.reflect.Field;

public class AutoTrimListener {
    @PrePersist
    @PreUpdate
    public void trim(Object entity) {

        for (Field field : entity.getClass().getDeclaredFields()) {

            if (field.getType().equals(String.class)
                    && field.isAnnotationPresent(AutoTrim.class)) {

                field.setAccessible(true);

                try {
                    String value = (String) field.get(entity);
                    AutoTrim ann = field.getAnnotation(AutoTrim.class);

                    if (value != null && value.length() > ann.max()) {
                        field.set(entity, value.substring(0, ann.max()));
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

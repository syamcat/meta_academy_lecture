package com.i5.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

@Configuration
public class ContextConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("section03/properties/subsection02/i18n/message");
        messageSource.setCacheSeconds(10);
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}

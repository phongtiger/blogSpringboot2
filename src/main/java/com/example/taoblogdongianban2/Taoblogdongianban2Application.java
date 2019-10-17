package com.example.taoblogdongianban2;

import com.example.taoblogdongianban2.fomatter.CategoryFormatter;
import com.example.taoblogdongianban2.service.BlogService;
import com.example.taoblogdongianban2.service.CategoryService;
import com.example.taoblogdongianban2.service.impl.BlogServiceImplWithSpringData;
import com.example.taoblogdongianban2.service.impl.CategoryServiceImplWithSpringData;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class Taoblogdongianban2Application {

    public static void main(String[] args) {
        SpringApplication.run(Taoblogdongianban2Application.class, args);
    }

    @Bean
    public BlogService customerService() {
        return new BlogServiceImplWithSpringData();
    }

    @Bean
    public CategoryService provinceService() {
        return new CategoryServiceImplWithSpringData();
    }

    @Configuration
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            CategoryService categoryService = appContext.getBean(CategoryService.class);
            Formatter categoryFormatter = new CategoryFormatter(categoryService);
            registry.addFormatter(categoryFormatter);
        }
    }
}

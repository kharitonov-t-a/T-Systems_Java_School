package com.web.shop.configuration;

import com.web.shop.converter.UserRoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.web.shop")
public class AppConfiguration extends WebMvcConfigurationSupport{

    @Autowired
    private UserRoleToUserProfileConverter userRoleToUserProfileConverter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(userRoleToUserProfileConverter);
//    }

    @Bean
    /**
     * Configure MessageSource to provide internationalized messages
     *
     */
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

//    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
//     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
//     * This is a workaround for this issue.
//     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer matcher) {
//        matcher.setUseRegisteredSuffixPatternMatch(true);
//    }

}
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Collections;

@Configuration
@PropertySource("classpath:thymeleaf.properties")
public class ThymeleafConfig {


@Bean
public TemplateResolver templateResolver(){
ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
templateResolver.setPrefix("C:\\Users\\dzefrej0\\IdeaProjects\\Test4EoNetworks\\src\\main\\resources\\templates");
templateResolver.setSuffix(".html");
templateResolver.setTemplateMode("HTML5");

return templateResolver;
}

@Bean
public SpringTemplateEngine templateEngine(){
SpringTemplateEngine templateEngine = new SpringTemplateEngine();
templateEngine.setTemplateResolver(templateResolver());
return templateEngine;
}

@Bean
public ViewResolver viewResolver(){
ThymeleafViewResolver viewResolver = new ThymeleafViewResolver() ;
viewResolver.setTemplateEngine(templateEngine());
viewResolver.setOrder(1);

return viewResolver;
}}
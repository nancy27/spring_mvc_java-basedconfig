package com.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ApplicationContext= new AnnotationConfigWebApplicationContext();
       ApplicationContext.register(AppConfiguration.class);

        DispatcherServlet dispatcherServlet= new DispatcherServlet(ApplicationContext);
        ServletRegistration.Dynamic myCustomDispatcherServlet= servletContext.
                addServlet("myDispatcherServlet",dispatcherServlet);
        myCustomDispatcherServlet.setLoadOnStartup(1);
        myCustomDispatcherServlet.addMapping("/Config/*");

    }
}


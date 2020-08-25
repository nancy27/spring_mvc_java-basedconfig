package com.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext xmlWebApplicationContext= new XmlWebApplicationContext();
        xmlWebApplicationContext.setConfigLocation("classpath:application-config.xml");

        DispatcherServlet dispatcherServlet= new DispatcherServlet(xmlWebApplicationContext);
        ServletRegistration.Dynamic myCustomDispatcherServlet= servletContext.
                addServlet("myDispatcherServlet",dispatcherServlet);
        myCustomDispatcherServlet.setLoadOnStartup(1);
        myCustomDispatcherServlet.addMapping("/Config/*");

    }
}


package ru.vlasovmb.minprofile.config;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{PersistenceConfig.class, WebConfig.class};
    }

    /**
     * Add H2SQL Servlet for console H2SQL
     * Default user: sa
     * Default password:
     * Name database look in "application.properties"
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("h2servlet", WebServlet.class);
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/console/*");
        super.onStartup(servletContext);
    }

    /**
     * Servlet WebApplicationContext delegated to Root WebApplicationContext
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}

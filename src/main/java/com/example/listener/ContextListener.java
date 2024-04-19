package com.example.listener;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LocalDateTime servletTimeInit = LocalDateTime.now();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("servletTimeInit",servletTimeInit);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}

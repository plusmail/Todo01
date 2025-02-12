package kroryi.listner;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class W2AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        log.info("-----------------초기화 진행--------------");
        log.info("-----------------초기화 진행--------------");
        log.info("-----------------초기화 진행--------------");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appName", "W2");

    }

    public void contextDestroyed(ServletContextEvent sce) {
        log.info("-----------------뒷정리 진행");
        log.info("-----------------뒷정리 진행");
        log.info("-----------------뒷정리 진행");
    }
}

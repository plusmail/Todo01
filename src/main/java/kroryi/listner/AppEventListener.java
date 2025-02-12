package kroryi.listner;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class AppEventListener
        implements ServletContextListener,
        ServletRequestListener,
        HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("🌐 애플리케이션 시작");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("🛑 애플리케이션 종료");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("📥 요청 수신됨: {}" , sre.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("📤 요청 처리 완료");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("👤 세션 생성됨: {}" ,se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("⏳ 세션 종료됨: {}" , se.getSession().getId());
    }

}

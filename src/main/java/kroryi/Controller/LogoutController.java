package kroryi.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;


@Log4j2
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        log.info("/logout->doGet");
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();
        // req.getcontextPath()   :8080/untitle2/ 프로젝트 경로 출력
        res.sendRedirect(req.getContextPath() + "/login");
    }
}

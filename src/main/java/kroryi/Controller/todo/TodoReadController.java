package kroryi.Controller.todo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.TodoDTO;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        log.info("/todo/read doGet-->");
        // ServletContext에 appName로 등록한 속성,값을 읽을 수 있고(애플리케이션 전역변수 취급)
        ServletContext servletContext = req.getServletContext();
        log.info("appName todo read: {}" , servletContext.getAttribute("appName"));


        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO dto = null;
        try {
            dto = todoService.get(tno);
            req.setAttribute("dto", dto);

            //
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exists = false;
            if (todoListStr != null && todoListStr.indexOf(tno + "-") >= 0) {
                exists = true;
            }
            log.info("쿠키 존재: {}", exists);
            if (!exists) {
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60 * 60 * 24);
                viewTodoCookie.setPath("/");
                res.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, res);

        } catch (SQLException e) {
            req.setAttribute("errorMessage", "유효한 TNO 값을 입력하시오.");
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, res);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie targetCookie = null;
        // cookies 배열
        if (cookies != null && cookies.length > 0) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(name)) {
                    targetCookie = ck;
                    break;
                }
            }
        }
        if (targetCookie == null) {
            targetCookie = new Cookie(name, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60 * 6024);
        }

        return targetCookie;
    }

}

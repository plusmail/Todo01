package kroryi.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
        Long tno =  Long.parseLong(req.getParameter("tno"));

        TodoDTO dto = null;
        try {
            dto = todoService.get(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, res);

        }catch (SQLException e){
            req.setAttribute("errorMessage", "유효한 TNO 값을 입력하시오.");
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, res);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}

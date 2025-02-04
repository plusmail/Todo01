package kroryi.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.TodoDTO;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        rd.forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // JSP-> input Tag 데이터-> DTO 변환
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), formatter))
                .build();


        log.info("/todo/register POST");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/todo/list");
    }

}

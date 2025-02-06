package kroryi.Controller.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
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
@WebServlet(urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //Servlet 의 초기화 작업에 사용
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long tno = Long.valueOf(req.getParameter("tno"));
        try {
            TodoDTO todoDTO = todoService.get(tno);
            req.setAttribute("dto", todoDTO);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String finishedStr = req.getParameter("finished");
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(Long.valueOf(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), formatter))
                .finished( finishedStr != null && finishedStr.equals("on"))
                .build();

        log.info("Modify--- doPost");
        log.info(todoDTO);
        try {
            todoService.modify(todoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/todo/list");
    }

}

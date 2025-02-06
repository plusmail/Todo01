package kroryi.Controller.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            todoService.remove(Long.valueOf(req.getParameter("tno")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/todo/list");
    }

}

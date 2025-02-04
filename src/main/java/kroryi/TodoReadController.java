package kroryi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.TodoDTO;
import kroryi.Service.TodoService;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("/todo/read");
        Long tno =  Long.parseLong(req.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        req.setAttribute("dto", dto);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        rd.forward(req, res);
    }

}

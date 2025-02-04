package kroryi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet(urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //Servlet 의 초기화 작업에 사용
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        rd.forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("수정: " +req.getParameter("title"));


        res.sendRedirect("/todo/list");
    }

}

package kroryi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.TodoDTO;
import kroryi.Service.TodoService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Todo List init호출");
    }
    // MVC Controller담당
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println(req.getHeader("User-Agent"));
//        System.out.println(req.getHeader("Host"));
//        System.out.println(req.getHeader("Content-Type"));
//        System.out.println(req.getHeader("Accept"));
//        System.out.println(req.getMethod());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getRequestURI()); // Uniform Resource Identifier(식별자)
//        // mailto:someone@example.com URI
//        System.out.println(req.getRequestURL()); // Uniform Resource Locator(위치)
//        System.out.println(req.getParameter("title"));
//        System.out.println(Arrays.toString(req.getParameterValues("title")));
//        System.out.println(req.getParameterNames());
//        // set하기전에 http://localhost:8080/todo/list?title=반가워&age=20 파라메터가 2개이고
//        req.setAttribute("name","강감찬");
//        req.setAttribute("title", req.getParameter("title"));
//        req.setAttribute("age", req.getParameter("age"));
//        // set해서 추가로 파라메터를 만들면 3개가 된다.
//        // jsp로 넘길때 3개의 파라메터라 전달 된다.
//
//        res.setCharacterEncoding("UTF-8");
//        res.setContentType("text/html; charset=utf-8");
////        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        // res.setStatus PrintWriter out 할때 사용
//        if(req.getParameter("title") == null){
//            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "서버에서 처리할 수 없는 오류가 발생했습니다.");
//        }
//
//        Cookie cookie = new Cookie("username", "세종대황");
//        cookie.setPath("/");
//        cookie.setMaxAge(60);
//        res.addCookie(cookie);
        System.out.println("/todo/list");
        // TodoService를 new 를 사용 않하고 있음.
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        req.setAttribute("list", dtoList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
//        rd.include(req, res);
        rd.forward(req, res);
    }

    public void destroy() {
        System.out.println("Todo list destory호출");
    }

}

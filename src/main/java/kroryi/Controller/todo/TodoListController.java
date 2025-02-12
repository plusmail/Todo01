package kroryi.Controller.todo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.DTO.TodoDTO;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/list.....................");

        // ServletContext에 appName로 등록한 속성,값을 읽을 수 있고(애플리케이션 전역변수 취급)
        ServletContext servletContext = req.getServletContext();
        log.info("appName: {}" , servletContext.getAttribute("appName"));

        try {
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        System.out.println("Todo list destory호출");
    }

}

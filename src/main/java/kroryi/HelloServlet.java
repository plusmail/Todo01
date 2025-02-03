package kroryi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//어노테이션
@WebServlet(value="/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String name = "홍길동";
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet kroryi.HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>스블릿 첫 페이지t"+name + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }

}

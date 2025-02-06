package kroryi.Controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.Service.MemberService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns = "/member/remove")
public class MemberRemoveController extends HttpServlet {
    private MemberService service = MemberService.INSTANCE;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            service.remove(req.getParameter("mid"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/member/list");
    }

}

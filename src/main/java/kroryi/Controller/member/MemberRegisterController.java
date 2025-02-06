package kroryi.Controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(urlPatterns = "/member/register")
public class MemberRegisterController extends HttpServlet {

    private MemberService service = MemberService.INSTANCE;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/member/register.jsp");
        rd.forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // JSP-> input Tag 데이터-> DTO 변환
        MemberDTO dto = MemberDTO.builder()
                .mid(req.getParameter("mid"))
                .mpw(req.getParameter("mpw"))
                .mname(req.getParameter("mname"))
                .memail(req.getParameter("memail"))
                .build();

        log.info("/member/register POST");
        log.info(dto);
        try {
            service.register(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/member/list");
//        res.sendRedirect("/member/login");
    }

}

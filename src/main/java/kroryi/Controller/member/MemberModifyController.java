package kroryi.Controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns = "/member/modify")
public class MemberModifyController extends HttpServlet {
    private MemberService service = MemberService.INSTANCE;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String mid = req.getParameter("mid");
        try {
            MemberDTO dto = service.get(mid);
            req.setAttribute("dto", dto);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/member/modify.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        MemberDTO dto = MemberDTO.builder()
                .mid(req.getParameter("mid"))
                .mpw(req.getParameter("mpw"))
                .memail(req.getParameter("memail"))
                .mname(req.getParameter("mname"))
                .build();

        log.info("Modify--- doPost");
        log.info("Modify -> doPost -> {}", dto);
        try {
            service.modify(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/member/list");
    }

}

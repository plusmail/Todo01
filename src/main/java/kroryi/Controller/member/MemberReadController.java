package kroryi.Controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(urlPatterns = "/member/read")
public class MemberReadController extends HttpServlet {

    private MemberService service = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        log.info("/member/read doGet-->");
        String mid = req.getParameter("mid");

        MemberDTO dto = null;
        try {
            dto = service.get(mid);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/member/read.jsp").forward(req, res);

        }catch (SQLException e){
            req.setAttribute("errorMessage", "유효한 MiD 값을 입력하시오.");
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, res);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}

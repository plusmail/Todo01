package kroryi.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet {
    private MemberService service = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        log.info("doGet-> login");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        log.info("doPost-> login");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // 추후에 DB연동 ID, PW 확인하고 ,, 기타 정보를 객체로 만들어서 세션에 저장
        try {
            MemberDTO dto = service.login(mid, mpw);
            //dto 있는 데이터 -> test01,홍길동,a@a.co.kr,1
            if(dto != null && dto.getPassword_match().equals("1")){
                HttpSession session = req.getSession();
                session.setAttribute("loginInfo", dto);
                res.sendRedirect("/");
            }else{
                res.sendRedirect("/login?result=error");
            }

        } catch (Exception e) {
            res.sendRedirect("/login?result=error");
        }

    }

}

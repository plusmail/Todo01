package kroryi.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import kroryi.Service.TodoService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.UUID;

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
        String auto = req.getParameter("auto");



        // 추후에 DB연동 ID, PW 확인하고 ,, 기타 정보를 객체로 만들어서 세션에 저장
        try {
            MemberDTO dto = service.login(mid, mpw);
            // test01:홍길동:a@a.co.kr:1:xxxx  xxxx의 uuid가 없는 상태

            // if문 또는 삼항연산자 역할
            boolean rememberMe = auto != null && auto.equals("on");
            log.info("rememberMe: {}" , rememberMe);
            if(rememberMe){
                // 280a8a4d-a27f-4d01-b031-2a003cc4c039 이런 형식
                String uuid = UUID.randomUUID().toString();
                service.updateUuid(mid, uuid); // 디비에 uuid없는 상태에서 생성한 uuid로 업데이트
                // 그러나 dto에 uuid를 기존 상태이므로 아래와 같이 값 업데이트
                dto.setUuid(uuid);


                // DB서버에 있는 UUID와 같은 값으로 Cookie에 UUID 사용 보안(사용자 일치)
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setPath("/");
                rememberCookie.setMaxAge(60*60*24*7);
                res.addCookie(rememberCookie);

            }
//            // UUID 사용처
//            1. 데이터베이스 식별자
//            2. 파일이름 또는 경로관리  ex) d3b07384-d9f0-4c3b-98c2-123456789abc.png
//            3. 세션관리 또는 인증 토큰 (OAuth) ex) f47ac10b58cc4372a5670e02b2c3d479


            //dto 있는 데이터 -> test01,홍길동,a@a.co.kr,1
            if(dto != null && dto.getPassword_match().equals("1")){
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(600);
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

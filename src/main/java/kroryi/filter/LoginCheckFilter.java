package kroryi.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.DTO.MemberDTO;
import kroryi.Service.MemberService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter-> login");

        // ServletRequest를 HttpServletRequest로 형 변환
        // doFilter의 전달 인자가 부모 클래스로 전달 되어서 변환 필요
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =  (HttpServletResponse) response;
        HttpSession session = req.getSession();

        log.info("doFilter-> session- getContextPath {}", req.getContextPath());
        if(session.getAttribute("loginInfo") == null){
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Cookie cookieSession = findCookie(req.getCookies(), "JSESSIONID");
        if(cookieSession == null){
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        Cookie setSessionCookie = new Cookie("JSESSIONID", cookieSession.getValue());
        setSessionCookie.setPath("/");
        setSessionCookie.setMaxAge(60*60*24*7);
        res.addCookie(setSessionCookie);

        // 브라우즈 Cookie에 있는 idea-xxxx , JSESSIONID, remember-me, viewTodos
        // 쿠키 이름,값을 배열로 서버에 전달한 것을 req.getCookies()로 받는다.
        Cookie cookie = findCookie(req.getCookies(), "remember-me");
        if(cookie == null){
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        log.info("doFilter-> cookie {} 가 존재", cookie.getValue());
        String uuid = cookie.getValue();
        try {
            MemberDTO dto = MemberService.INSTANCE.getByUUID(uuid);

            if(dto == null){
                throw new Exception("사용자 쿠키 정보가 없습니다. 다시시도..");
            }
//            session.setAttribute("loginInfo", dto);
//            session.setMaxInactiveInterval(600);


        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("/login");
        }
        chain.doFilter(req, res);

    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie targetCookie = null;
        // cookies 배열
        if (cookies != null && cookies.length > 0) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(name)) {
                    targetCookie = ck;
                    break;
                }
            }
        }
        if (targetCookie == null) {
            targetCookie = new Cookie(name, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60 * 6024);
        }

        return targetCookie;
    }



}

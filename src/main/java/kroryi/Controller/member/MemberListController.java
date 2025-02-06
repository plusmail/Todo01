package kroryi.Controller.member;

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
import java.util.List;
@Log4j2
@WebServlet(urlPatterns = "/member/list")
public class MemberListController extends HttpServlet {

    private MemberService service = MemberService.INSTANCE;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("Member List doGet ");

        try{
            List<MemberDTO> dtoList = service.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/member/list.jsp").forward(req, res);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

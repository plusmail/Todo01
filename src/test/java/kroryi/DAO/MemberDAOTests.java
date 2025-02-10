package kroryi.DAO;

import kroryi.VO.MemberVO;
import kroryi.VO.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class MemberDAOTests {

    private  MemberDAO dao;

    @BeforeEach
    public void ready(){
        System.out.println("Before each Test");
        dao  = new MemberDAO();
    }

    @Test
    public void testInsert() throws Exception{
        MemberVO vo = MemberVO.builder()
                .mid("test01")
                .mpw("1111")
                .memail("a@a.co.kr")
                .mname("홍길동")
                .build();

        dao.insert(vo);
    }

    @Test
    public void testList() throws Exception{
        List<MemberVO> list = dao.selectAll();

        list.forEach( vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        String mid = "test01";
        MemberVO vo = dao.selectOne(mid);
        log.info("Member->Select one: {}", vo);
    }

    @Test
    public void testUpdateOne() throws Exception{
        MemberVO vo = MemberVO.builder()
                .mid("test01")
                .mpw("2222")
                .memail("b@a.co.kr")
                .mname("강감찬")
                .build();
        dao.updateOne(vo);
    }

    @Test
    public void testDeleteOne() throws Exception{
        String mid = "test01";

        dao.deleteOne(mid);
    }

    @Test
    public void testLogin() throws Exception{
        String mid = "test01";
        String mpw = "1111";
        MemberVO vo = dao.getMemberWithPasswordCheck(mid, mpw);
        log.info("Member->LoginTest : {}", vo);
    }
}

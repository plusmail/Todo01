package kroryi.DAO;

import kroryi.VO.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private  TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        System.out.println("Before each Test");
        todoDAO  = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("할일 첫번째")
                .dueDate(LocalDate.of(2025,2,5))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach( vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 1L;
        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testUpdateOne() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("새로 수정 한 일...")
                .dueDate(LocalDate.of(2025,2,4))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }

    @Test
    public void testDeleteOne() throws Exception{
        Long tno = 2L;

        todoDAO.deleteOne(tno);
    }
}

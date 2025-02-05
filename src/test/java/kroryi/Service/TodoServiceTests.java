package kroryi.Service;

import kroryi.DTO.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .title("데이터 저장 테스트")
                .dueDate(LocalDate.now())
                .build();

        log.info("testRegister-> DTO생성", todoDTO);
        log.error("-------------------");
        todoService.register(todoDTO);
    }

}

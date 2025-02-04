package kroryi.Service;

import kroryi.DTO.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {

    // 하나의 인스턴스만 존재하도록 보장하는 방식
    // 싱글톤 패턴  static final로 선언한 멤버들
    INSTANCE;
//    private static final TodoService INSTANCE = new TodoService();


    public void register(TodoDTO todoDTO) {
        System.out.println("todoDTO" + todoDTO);
    }

    public List<TodoDTO> getList(){
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("할일 ..." +i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        System.out.println(todoDTOS.toString());
        return todoDTOS;
    }

    public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("셈플..... todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }

}


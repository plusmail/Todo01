package kroryi.Service;

import kroryi.DAO.TodoDAO;
import kroryi.DTO.TodoDTO;
import kroryi.Util.MapperUtil;
import kroryi.VO.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Log4j2
public enum TodoService {

    // 하나의 인스턴스만 존재하도록 보장하는 방식
    // 싱글톤 패턴  static final로 선언한 멤버들
    INSTANCE;
//    private static final TodoService INSTANCE = new TodoService();

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception{

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//        System.out.println("todoVO:" + todoVO);
        log.info("TodoVO출력:", todoVO);

        dao.insert(todoVO);

    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList......");
        log.info(voList);
        // DB -> VO -> DTO 로 맵핑
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno......:" , tno);
        TodoVO todoVO = dao.selectOne(tno);

        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

}


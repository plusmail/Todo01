package kroryi.Service;

import kroryi.DAO.MemberDAO;
import kroryi.DAO.TodoDAO;
import kroryi.DTO.MemberDTO;
import kroryi.DTO.TodoDTO;
import kroryi.Util.MapperUtil;
import kroryi.VO.MemberVO;
import kroryi.VO.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService(){
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(MemberDTO dto) throws Exception{

        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        log.info("MemberVO 출력: {}", vo);

        dao.insert(vo);

    }

    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> voList = dao.selectAll();
        log.info("Member listAll -> voList......");
        log.info(voList);
        // DB -> VO -> DTO 로 맵핑
        List<MemberDTO> dto = voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());

        return dto;
    }

    public MemberDTO get(String mid) throws Exception {
        log.info("get -> mid......: {}" , mid);

        MemberVO vo = dao.selectOne(mid);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);

        return dto;
    }

    public void remove(String mid) throws Exception {
        log.info("Remove mid......: {}" , mid);

        dao.deleteOne(mid);
    }

    public void modify(MemberDTO dto) throws Exception {
        log.info("modify ......{}", dto);

        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        dao.updateOne(vo);
    }

}


package kroryi.VO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDateTime dueDate;
    private boolean finished;

}

//TodoVO todoVO2 = new TodoVO(1L, "dfsdfdf", true,"2020-12-01");
//TodoVO todoVO1 = new TodoVO(2L, "sdfsdfsdf", true,"2020-12-01");
////
//TodoVO todoVO = TodoVO
//        .builder()
//        .finished(true)
//        .tno(1L)
//        .title("dfsdfsdfdsf")
//        .dueDate(LocalDateTime.parse("2023-01-20"))
//        .build();
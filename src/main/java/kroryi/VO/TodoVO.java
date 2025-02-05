package kroryi.VO;

import lombok.*;

import java.time.LocalDate;

// VO Getter만 사용(Read Only)
// 멤버(필드)는 private로 선언  DTO의 차이
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}

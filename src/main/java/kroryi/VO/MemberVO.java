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
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String memail;
    private String password_match;
    private String uuid;
}

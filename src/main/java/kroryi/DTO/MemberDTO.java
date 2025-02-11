package kroryi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor // 전달인자가 없는 기본 생성자
@AllArgsConstructor // 필드 숫에 맞게 생성자를 생성
@Data  // @Data Getter, Setter, ToString 포함
// DTO는 필드값을 Read, Write 기능 같이 있는 클래스
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String memail;
    private String password_match;
    private String uuid;

}

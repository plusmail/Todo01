package kroryi.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BoardVO {
    private int bid;
    private String title;
    private String writer;
    private String content;
    private LocalDate writer_date;
    private LocalDate modified_date;
    private int count;
}

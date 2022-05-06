package kr.datasolution.msa.frontend.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 게시물 DTO CLASS
 */
@Getter
@Setter
public class BoardDto {
    /** 게시물 ID */
    @Schema(description = "게시물 ID")
    private int ID;

    /** 제목 */
    @Schema(description = "게시물 제목")
    private String TITLE;

    /** 내용 */
    @Schema(description = "게시물 내용")
    private String CONTENTS;

    /** 등록일시 */
    @Schema(description = "등록일자")
    private LocalDateTime REG_DT;

    /** 수정일시 */
    @Schema(description = "수정일자")
    private LocalDateTime UPD_DT;
}

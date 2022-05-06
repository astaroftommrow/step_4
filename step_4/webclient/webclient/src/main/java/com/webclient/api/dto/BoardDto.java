package com.webclient.api.dto;


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
    private int ID;

    /** 제목 */
    private String TITLE;

    /** 내용 */
    private String CONTENTS;

    /** 등록일시 */
    private LocalDateTime REG_DT;

    /** 수정일시 */
    private LocalDateTime UPD_DT;
}

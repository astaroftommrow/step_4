package com.webclient.api.controller;

import com.webclient.api.dto.BoardDto;
import com.webclient.api.service.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@Slf4j
@Controller
@RequestMapping("/clientboard")
@RequiredArgsConstructor
public class WebController {
    /** 화면전환 기능들을 가져오는 역할 **/

    private final WebService webService;


    /**
     * 1-1. 게시물 목록 Ajax
     * @param
     * @return3
     **/
    @RequestMapping("/getboardlist")
    public Flux<BoardDto> getBoardList(){
        log.info("목록조회 Ajax 발동");
        return webService.getBoardList();
                /** "WebService" 파일의 '게시물 목록 조회'로 반환 **/
    }


    /**
     * 1-2. 게시물 목록 조회 화면 이동
     * @return
     */
    @GetMapping("")
    public String getViewBoardMain(){
        log.info("목록조회 화면 가져오기");  /** 로그에 찍히는 이름 **/
        return "main";  /** BoardController의 getViewBoardMain **/
    }


    /**
     * 2-1. 게시물 상세 조회 Ajax
     **/
    @GetMapping("/getboard/{id}")
    public Flux<BoardDto> getBoard(@PathVariable("id") String id){
        /** @PathVariable: url에서 각 구분자에 들어오는 값을 처리해야 할 때 사용 **/
        log.info("상세조회 Ajax 발동");  /** 로그에 찍히는 이름 **/
        return webService.getBoard(id);
    }


    /**
     * 2-2. 게시물 상세 조회 화면 이동
     * @param
     * @return
     */
    @GetMapping("{id}")
    public String getViewBoard(@PathVariable("id") String id){
        log.info("게시물 상세 조회 화면 가져오기");
        return "info"; /** BoardController의 getViewBoard **/
    }


    /**
     * 3-1. 게시물 등록 처리
     * @param boardDto
     * @return
     */
    @PostMapping("")
    public String addBoard(BoardDto boardDto){
        log.info("게시물 등록처리 발동");
        webService.addBoard(boardDto);
        return "redirect:/clientboard";
    }


    /**
     * 3-2. 게시물 등록 화면 이동
     * @return
     */
    @GetMapping("/new")
    public String getViewBoardNew(){
        log.info("게시물 등록 화면 가져오기");
        return "new";     /** BoardController의 getViewBoardNew **/
    }


    /**
     * 4-1. 게시물 수정 처리
     */
    @PutMapping("{id}")
    public String modBoard(@PathVariable("id") Integer id, BoardDto boardDto){
        log.info("게시물 수정처리 발동");
        System.out.println(boardDto.getTITLE());
        System.out.println(boardDto.getCONTENTS());
        webService.modBoard(id, boardDto);
        return "main";
    }


    /**
     * 4-2. 게시물 수정 화면 이동
     */
    @GetMapping ("/edit/{id}")
    public String getViewBoardEdit(){
        log.info("게시물 수정 화면 가져오기");
        return "edit";    /** BoardController의 getViewBoardEdit **/
    }




    /**
     * 5. 게시물 삭제 처리
     */
    @DeleteMapping("{id}")
    public String removeBoard(@PathVariable("id") Integer id){
        log.info("게시물 삭제처리 발동");
        webService.removeBoard(id);
        return "redirect:/clientboard";
    }

    
}

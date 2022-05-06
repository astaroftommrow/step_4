package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;

    /**
     * 게시물 목록 조회 화면 이동
//     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */



    @GetMapping("")
    public List<BoardDto> getViewBoardMain() {
        List<BoardDto> boardList = boardService.getBoardList();
        return boardList;
        //return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardList());
        //return "board/main";
    }

    /**
     * 게시물 상세 조회 화면 이동
//     * @param id 게시물 ID
//     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     **/

//    @ApiOperation(value = "select list more close" , notes = "select from board list too close")
//    @GetMapping("{id}")
//    public String getViewBoard(
//           @PathVariable("id") int id,
//            ModelMap map) {
//        map.put("info", boardService.getBoard(id));
//        return "board/info";
//    }

    @GetMapping("{id}")
    @Operation(description = "게시물 상세 조회 API")
    public ResponseEntity<BoardDto> getViewBoard(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoard(id));
    }







    /**
     * 게시물 등록 화면 이동
     * @return 게시물 등록 화면 경로
     */
    @GetMapping("new")
    public String getViewBoardNew() {
        return "board/new";
    }




    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 수정 화면 경로
     */
    @GetMapping("{id}/edit")
    public String getViewBoardEdit(
            @PathVariable("id") int id,
            ModelMap map) {
        map.put("info", boardService.getBoard(id));
        return "board/edit";
    }






    /**
     * 게시물 등록 처리
//    * @param boardDto 게시물 등록 데이터
//     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
//    @ApiOperation(value = "insert board" , notes = "finish insert board list")
//    @PostMapping("")
//    public String addBoard(
//            @ModelAttribute BoardDto boardDto,
//            ModelMap map) {
//        boardService.addBoard(boardDto);
//        return "redirect:/board/" + boardDto.getID();
//    }
    @PostMapping("")
    @Operation(description = "게시물 등록 처리 API")
    public int addBoard(@RequestBody BoardDto boardDto) {
        int resultCnt = boardService.addBoard(boardDto);
        return resultCnt;
    }






    /**
     * 게시물 수정 처리
//     * @param boardDto 게시물 수정 데이터
//     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
//    @ApiOperation(value = "update board" , notes = "finish update board list")
//    @PutMapping("{id}")
//    public String modBoard(
//            @PathVariable("id") int id,
//            @ModelAttribute BoardDto boardDto,
//            ModelMap map) {
//        boardDto.setID(id);
//        boardService.modBoard(boardDto);
//        return "redirect:/board/" + id;
//    }
    @PutMapping("{id}")
    @Operation(description = "게시물 수정 처리 API")
    public void modBoard(@PathVariable("id") int id, @RequestBody BoardDto boardDto) {
        //수정 대상 ID값을 Dto SetID에 적재한다.
        boardDto.setID(id);
        boardService.modBoard(boardDto);

    }







    /**
     * 게시물 삭제 처리
//     * @param id 삭제 대상 게시물 ID
//     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 호출
     */
//    @ApiOperation(value = "delete board" , notes = "finish delete board list")
//    @DeleteMapping("{id}")
//    public String removeBoard(
//            @PathVariable("id") int id,
//            ModelMap map) {
//        boardService.removeBoard(id);
//        return "redirect:/board";
//    }
    @DeleteMapping("{id}")
    @Operation(description = "Swagger 게시물 삭제 처리 API")
    public int removeBoard(@PathVariable("id") int id) {
        int resultCnt = boardService.removeBoard(id);
        return resultCnt;
    }



}

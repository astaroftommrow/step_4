package com.webclient.api.service;


import com.webclient.api.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;



@Service
@Slf4j
public class WebService {
   /** API 기능들을 가져오는 역할 **/

   private WebClient webClient = WebClient.builder()
           .baseUrl("http://localhost:8081/board/")
           .build();



   /**1. 게시물 목록조회 **/
   public Flux<BoardDto> getBoardList(){
      log.info("목록 조회");// 로그에 찍히는 이름
      return webClient.get()
              .uri("")

              .retrieve()
              .bodyToFlux(BoardDto.class);
   }


   /**2. 게시물 상세조회 + getMapper **/
   public  Flux<BoardDto> getBoard(String id){
      log.info("목록 상세조회");/** 로그에 찍히는 이름**/
      return webClient.get()  /** get방식으로 매핑 받겠다 **/
              .uri("/"+id) /** BoardController의 mapper파라미터 ="{id}" **/
              .retrieve()
              .bodyToFlux(BoardDto.class);
   }


   /**3. 게시물 등록 + postMapper **/
   public Void addBoard(BoardDto boardDto){
      log.info("목록 등록");   /** 로그에 찍히는 이름**/

      return webClient.post() /** post방식으로 매핑 받겠다 **/
              .uri("") /** BoardController의 mapper파라미터 ="" **/
              .bodyValue(boardDto)/** BoardDto의 객체 boardDto를 '바디형태'로 응답하겠다 **/

              .retrieve()
              .bodyToMono(Void.class)
              .block(); /** block()이 있다 **/
   }


   /**4. 게시물 수정 + putMapper **/
   public BoardDto modBoard(Integer id, BoardDto boardDto){
      log.info("게시물 수정");
      boardDto.setID(id);
      System.out.println(id);
      System.out.println(boardDto.getTITLE());
      return webClient.put()  /** put방식으로 매핑 받겠다 **/
              .uri("/" +id)/** BoardController의 mapper파라미터 ="{id}" **/
              .bodyValue(boardDto)
              .retrieve()
              .bodyToMono(BoardDto.class)
              .block();
   }


   /**5. 게시물 삭제 + deleteMapper **/
   public  Void removeBoard(Integer id){
      log.info("게시물 삭제");

      return webClient.delete()  /** delete방식으로 매핑 받겠다 **/
              .uri("/" + id)/** BoardController의 mapper파라미터 ="{id}" **/

              .retrieve()
              .bodyToMono(Void.class)
                     /** 예외처리:데이터가 없을 경우 변환 시 새로운 객체를 만들어서 return한다 **/
              .block();

   }


}

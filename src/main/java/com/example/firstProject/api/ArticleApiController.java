package com.example.firstProject.api;

import com.example.firstProject.dto.*;
import com.example.firstProject.domain.Article;
import com.example.firstProject.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    // GET : 글 조회하기
    // 전체 조회
    @GetMapping("/api/articles")
    public Result index() {

        List<Article> list = articleService.index();

        // 엔티티 -> dto변환
        List<ArticleForm> collect = list.stream()
                .map(a -> new ArticleForm(a.getId(),a.getTitle(), a.getContent()))
                .toList();

        // ListDTO를 Result 타입으로 감싸서 반환하기
        return new Result(collect);
    }

    // 글 번호로 특정 글만 조회
    @GetMapping("/api/articles/{id}")
    public ResponseDTO show(@PathVariable Long id) {
        Article article = articleService.show(id);

        //조회한 글 번호,제목,내용 보여주기
        return new ResponseDTO (article.getId(), article.getTitle(), article.getContent());

    }

    // POST : 글 생성하기
    @PostMapping("/api/articles")
    public ResponseDTO  create(@RequestBody @Valid CreateArticleRequest request) {

        // 객체 생성시 빌더 패턴 적용
        Article article=Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Long savedId = articleService.create(article);
        Article findAtricle = articleService.show(savedId);

        // 생성된 글 번호,제목,내용 보여주기
        return new ResponseDTO (findAtricle.getId(), findAtricle.getTitle(), findAtricle.getContent());

    }

    // PUT
    @PatchMapping ("/api/articles/{id}")
    public ResponseDTO  update(@PathVariable Long id,
                               @RequestBody @Valid UpdateArticleRequest request) {

        // 빌더 패턴 적용
       Article article= Article.builder()
                .id(request.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .build();

       /* Article article=new Article(request.getId(),request.getTitle(),request.getContent());*/

       articleService.update(id,article); // 업데이트
       Article findArticle = articleService.show(id); // 업데이트 된 글 조회하기

        return new ResponseDTO (findArticle.getId(), findArticle.getTitle(), findArticle.getContent());
    }

    //DELETE
    @DeleteMapping("/api/articles/{id}")
    public DeleteArticleResponse delete(@PathVariable Long id){

        Long deleted = articleService.delete(id);

        // 삭제한 글의 id 값 알려주기
        return new DeleteArticleResponse(deleted);
    }




    //트랜잭션
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody @Valid List<ArticleForm> dtos){

        List<Article> createdList= articleService.transactionTest(dtos);

        return (createdList!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }





}

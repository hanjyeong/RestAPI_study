package com.example.firstProject.service;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository; // 리파지터리 주입

    //GET
    // 전체 글 목록 조회
    public List<Article> index() {
        return articleRepository.findAll();
    }
    // id로  글 조회
    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    // CREATE
    public Article create(ArticleForm dto) {
        // DTO -> 엔티티로 변환하기
        Article entity= dto.toEntity();
        // Body에 id값을 넣어준 경우, 오류 처리
        //why? Bdoy에 id값을 넣으면 해당id를 가진 글이 "수정"되기 때문에 Body에 id값 전송X
        if(entity.getId()!=null){
            return null;
        }
        return articleRepository.save(entity);
    }

    // PATCH
    public Article update(Long id,ArticleForm dto) {
        // 1. DTO -> 엔티티 변환하기
        Article article = dto.toEntity();
        log.info("article= "+article.toString());

        // 2. 수정할 데이터 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        log.info("targer= "+target.toString());

        // 3. 잘못된 요청 처리하기
        if (target == null || id != article.getId()) {
            // 조회하는 데이터가 없거나, id값을 다르게 입력한 경우
            // 400, 잘못된 요청 응답
            log.info("잘못된 요청! id: {}, article: {}", id, article);
            return null;
        }

        // 4. 업데이트 및 정상 응답(200)하기
        //일부 데이터만 수정할 수 있도록 patch메서드 작성
        target.patch(article);
        Article updated = articleRepository.save(target); // 수정 내용 DB에 최종 저장
        log.info("updated = "+updated.toString());

        return updated;
    }

    //DELETE
    public Article delete(Long id) {

        // 삭제 요청한 데이터가 DB에 존재하는지 확인
        Article findEntity = articleRepository.findById(id).orElse(null);
        // 없다면 잘못된 요청으로 처리
        if(findEntity==null){
            return null;
        }
        // 있으면 대상을 삭제하기
        articleRepository.delete(findEntity);
        return findEntity; // DB에서 삭제한 대상을 반환
    }

    //트랜잭션 예시
    @Transactional
    public List<Article> transactionTest(List<ArticleForm> dtos) {

        //1 dto 묶음을 엔티티 묶음으로 반환
        List<Article> articleList=dtos.stream()
                .map(dto->dto.toEntity())
                .collect(Collectors.toList());;
        //2.엔티티 묶음을 DB에 저장
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        //3.강제 예외 발생 시키기
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("실패!"));
        //4. 결과 값 반환하기
        return articleList ;
    }


}

package com.example.firstProject.controller;


import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.domain.Article; //Article 클래스 임포트
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
@Slf4j // 로깅 기능을 위한 어노테이션 추가
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    // 글 생성하기 create
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        // 매개변수를 통해 폼 데이터를 바로 dto로 받기
//        System.out.println(form.toString()); // dto에 잘 담겼는지 확인하기
        log.info(form.toString());

        //1. dto를 엔티티로 변환
        Article article= form.toEntity();
//        System.out.println(article.toString()); // dto 값이 엔티티에 잘 담겼는지 확인
        log.info(article.toString());

        //2. 리파지터리로 엔티티를 DB에 저장하기
        Article saved= articleRepository.save(article); //article 엔티티를 저장해 saved 엔티티 반환
//        System.out.println(saved.toString());
        log.info(saved.toString());

        return "articles/index";
    }

    // 단일 데이터 조회
    @GetMapping("/articles/{id}") // id 값을 가지는 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){

        log.info("id= " + id);
        // DB에 조회하려는 데이터가 없다면 null 리턴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        /* Optional<> 을 이용하는 이유
         Optional<Article> articleEntity = articleRepository.findById(id);
         DB에서 리턴하는 엔티티는 Article이 아닌 Optional<Article> */

        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);

        return "articles/show";

    }

    // 데이터 목록 조회
    @GetMapping("/articles")
    public String index(Model model){

        //1. ArrayList로 반환
        ArrayList<Article> articleEntityList = articleRepository.findAll();

        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";

    }

    // 글 수정하기

    //1. 수정할 데이터 가져오기
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id,Model model){

        // 수정할 글 가져오기
       Article articleEntity =  articleRepository.findById(id).orElse(null);
       // 모델에 데이터 등록하기
        model.addAttribute("article",articleEntity);
        // 뷰 페이지 설정하기
        return "articles/edit";
    }

    //2. 수정된 데이터 DB에 저장하기
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        // 폼 데이터 DTO로 변환
        // 1. DTO -> entity로 변환하기
        Article editEntity = form.toEntity();
        log.info(editEntity.toString()); // entity로 잘 변환 됐는지 확인

        // 2. 엔티티를 DB에 저장하기
        // 2-1 기존 데이터 가져오기
        Article target = articleRepository.findById(editEntity.getId()).orElse(null);

        // 2-2 기존 데이터 값 갱신하기
        if(target!=null){
            articleRepository.save(editEntity); // 엔티티를 저장(갱신)
        }


        return "articles/index"; // 목록 화면 반환
    }

    //삭제
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id){

        // id에 해당하는 데이터를 DB에서 조회
        Article findEntity= articleRepository.findById(id).orElse(null);
        log.info(findEntity.toString());

        // 데이터가 있는 경우 삭제하기
        if(findEntity!=null){
             articleRepository.delete(findEntity);
        }

        return "";

    }


}

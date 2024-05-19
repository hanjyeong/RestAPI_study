/*
package com.example.firstProject.service;

import com.example.firstProject.service.ArticleService;
import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 부트 연동 테스트 (통합 테스트)
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L, "aaaa", "1111");
        Article b = new Article(2L, "bbbb", "2222");
        Article c = new Article(3L, "cccc", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
        // 2. 실제 데이터
        List<Article> articles = articleService.index();

        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "aaaa", "1111");
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력() {
        // 1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto_입력() {
        // 1. 예상 데이터
        String title = "dddd";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패_id가_포함된_dto_입력() {
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_성공_존재하는_id와_title_content가_있는_dto입력(){
        //given
        Long id=3L;
        String title="클로로";
        String content = "짱 머싯어";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        //when
        Article article=articleService.update(id,dto);
        //then
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void update_성공_존재하는_id와_title만_있는_dto입력(){
        //given
        Long id=3L;
        String title="클로로";
        String content = null;
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        //when
        Article article=articleService.update(id,dto);
        //then
        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void update_실패_존재하지_않는_id의_dto입력(){
        //given
        Long id=100L;
        String title="클로로";
        String content = "짱";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        //when
        Article article=articleService.update(id,dto);
        //then
        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void delete_성공(){

        //예상데이터
        Long id=2L;
        Article expected = new Article(id, "bbbb", "2222");
        //실제 데이터
        Article article= articleService.delete(id);
        //then
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void delete_실패(){
        //예상데이처터
        Long id=100L;
        Article expected = null;
        //when
        Article article=articleService.delete(id);
        //then
        assertEquals(expected,article);

    }



}*/

package com.example.firstProject.dto;

import com.example.firstProject.domain.Article;
import lombok.*;

@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor // 기본 생성자 무조건 추가?
@ToString
@Getter
@Setter
public class ArticleForm {

    private Long id;
    private String title; // 제목을 받을 필드
    private String content; // 내용을 받을 필드


    // dto 객체를 엔티티 객체로 변환
    public Article toEntity() {
        return new Article(id,title,content);
    }
}

package com.example.firstProject.dto;

import com.example.firstProject.entity.Article;
import lombok.*;

@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor // 기본 생성자 추가?
@ToString
@Getter
@Setter
public class ArticleForm {

    private Long id;
    private String title; // 제목을 받을 필드
    private String content; // 내용을 받을 필드

    //전송 받은 제목과 내용을 필드에 저장하는 생성자 추가
    // 데이터를 잘 받았는지 확인할 toString( ) 메서드 추가

    // dto 객체를 엔티티 객체로 변환
    public Article toEntity() {
        // 엔티티 객체를 생성해서 매개변수로 필드값 전달
        return new Article(id,title,content);
    }
}

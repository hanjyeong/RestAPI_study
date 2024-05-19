package com.example.firstProject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder // 빌더 패턴 적용
@AllArgsConstructor // 필드 초기화 생성자
@NoArgsConstructor // 기본 생성자
@ToString
@Getter
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column // title 필드 선언 DB테이블의 title 열과 연결
    private String title;
    @Column // content 필드 선언 DB테이블의 content 열과 연결
    private String content;


    //patch()메서드
    public void patch(Article article){
        if(article.title!=null){ // 수정할 title 값을 전송했음
            this.title= article.title;
        }
        if(article.content!=null){ // 수정할 content 값을 전송했음
            this.content=article.content;
        }

    }




}

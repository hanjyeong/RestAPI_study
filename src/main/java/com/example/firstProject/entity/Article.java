package com.example.firstProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // DB에 테이블이 생성
@AllArgsConstructor // 필드 초기화 생성자
@NoArgsConstructor // 기본 생성자 !!
@ToString
@Getter
@Setter
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column // title 필드 선언 DB테이블의 title 열과 연결
    private String title;
    @Column // content 필드 선언 DB테이블의 content 열과 연결
    private String content;

    /*public Article(String title,String content){
        this.title=title;
        this.content=content;
    }*/
    // 수정할 내용이 있는 경우에만 동작



    //Article 생성자 추가
    //Article toString() 메서드 추가

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

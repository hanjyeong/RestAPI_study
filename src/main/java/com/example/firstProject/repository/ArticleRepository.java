package com.example.firstProject.repository;

import com.example.firstProject.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Override
    ArrayList<Article> findAll(); //Iterable -> ArrayList로 수정

}




// jpa에서 제공하는 CrudRepository 인터페이스 상속
/* CrudRepository<Article,Long>
 * 관리 대상 엔티티의 클래스 타입
 * 관리 대상 엔티티의 PK 타입
 *
 * ArrayList는 Iterable을 상속받은 클래스이므로 반환 타입이 달라져도 오버라이딩으로 간주
 * */

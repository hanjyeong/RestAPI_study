package com.example.firstProject.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor // 기본 생성자
public class UpdateArticleRequest {

// 글 업데이트 요청에 사용하는 dto
    @NotNull(message = "수정하고 싶은 글의 id를 꼭 입력해주세요")
    private Long id;
    private String title;
    private String content;
}

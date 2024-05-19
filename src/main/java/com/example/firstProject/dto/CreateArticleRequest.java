package com.example.firstProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor // 기본 생성자
public class CreateArticleRequest {
// 글 생성시 사용하는 dto
    @NotBlank(message = "제목을 반드시 입력해주세요")
    private String title;
    private String content;

}

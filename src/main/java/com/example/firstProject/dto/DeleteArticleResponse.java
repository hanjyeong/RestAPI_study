package com.example.firstProject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DeleteArticleResponse {

    // 글 삭제에 대한 응답 dto
    private Long id;
}

package com.example.firstProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

    // 모든 요청 처리 에 대한 응답으로 사용하는 DTO
    private Long id;
    private String title;
    private String content;
}

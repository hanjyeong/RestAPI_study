/*
package com.example.firstProject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   // 전체 예외 처리
   @ExceptionHandler(value = Exception.class)
   public Map<String,String> handle(Exception e){
      Map<String,String> map=new HashMap<>();
      map.put("errMsg: ", e.getMessage());
      return map;
   }

   // NullPointerException 처리
   @ExceptionHandler(value = NullPointerException.class)
   public Map<String,String> handle(NullPointerException e){
      Map<String,String> map=new HashMap<>();
      map.put("errMsg: ", e.getMessage());
      return map;
   }

   // @NotBlank 예외 처리
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException e){
      Map<String,String> map= new HashMap<>();

   }



}
*/

package com.example.firstProject.service;

import com.example.firstProject.dto.CoffeeDto;
import com.example.firstProject.entity.Coffee;
import com.example.firstProject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> list() {
        return coffeeRepository.findAll();
    }

    public Coffee findById(Long id) {
        // 찾는 데이터가 DB에 있는지 확인
        Coffee findEntity = coffeeRepository.findById(id).orElse(null);
        // 데이터가 없다면 잘못된 요청 처리
        if(findEntity==null){
            log.info("찾고자 하는 id:{}를 가진 데이터가 없습니다!!",id);
            return null;
        }
        return findEntity;
    }

    public Coffee create(CoffeeDto dto) {
        Coffee entity = dto.toEntity();
        return coffeeRepository.save(entity);
    }

    public Coffee update(Long id, CoffeeDto dto) {
        // 1. 수정할 데이터 엔티티로 저장하기
        Coffee entity = dto.toEntity();
        // 2. 데이터가 있는지 확인하기
        Coffee target = coffeeRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if(target==null || id!= entity.getId()){
            //400 클라이언트 요청 오류
            return null;
        }
        // 4. 업데이트 및 상태 응답하기
        target.patch(entity);
        coffeeRepository.save(target); // 수정된 내용 DB에 저장
        return target;
    }

    public Coffee delete(Long id) {
        // 데이터 조회하기
        Coffee findEntity = coffeeRepository.findById(id).orElse(null);
        // 잘못된 요청 처리하기
        if(findEntity==null){ // 삭제할 데이터가 DB에 없는 경우
            return null;
        }
        // 해당 데이터 삭제하고 상태 객체 응답하기
        coffeeRepository.delete(findEntity);
        return findEntity; // 삭제한 엔티티 리턴하기
    }
}

package com.example.firstProject.api;


import com.example.firstProject.dto.CoffeeDto;
import com.example.firstProject.entity.Coffee;
import com.example.firstProject.repository.CoffeeRepository;
import com.example.firstProject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CoffeeApiController {

   @Autowired
   private CoffeeService coffeeService;

    //Get
    // 전체 데이터 조회
    @GetMapping("/api/coffees")
    public ResponseEntity<List<Coffee>> list(){

        List<Coffee> createdList = coffeeService.list();
        return (createdList!=null)?
                ResponseEntity.status(HttpStatus.OK).body(createdList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // id값으로 하나의 데이터 조회하기
    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> findById(@PathVariable Long id){

        Coffee findEntity= coffeeService.findById(id);
        return (findEntity!=null)?
                ResponseEntity.status(HttpStatus.OK).body(findEntity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    //Post : 생성하기
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto dto){

        Coffee created= coffeeService.create(dto);

        return (created!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //Patch : 수정하기
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id,
                                         @RequestBody CoffeeDto dto){

       Coffee updated= coffeeService.update(id,dto);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.CREATED).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    //Delete
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id){

        Coffee deleted = coffeeService.delete(id);
        return (deleted!=null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}

package com.example.firstProject.dto;

import com.example.firstProject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CoffeeDto {

    private Long id;
    private String name;
    private Long price;


    // DTO -> 엔티티 변환
    public Coffee toEntity(){
        return new Coffee(id,name, price);
    }
}

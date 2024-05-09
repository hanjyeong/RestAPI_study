package com.example.firstProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coffee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    //patch메서드
    public void patch(Coffee entity){
        if(entity.getName()!=null){
            this.name= entity.getName();
        }
        if(entity.getPrice()!=null){
            this.price=entity.getPrice();
        }
    }
}

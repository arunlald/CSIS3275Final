package com.example.csis3275final.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custno;
    private String custname;
    private double cdep;
    private int nyears;
    private String savtype;

    public Savings(String type) {
    }
}

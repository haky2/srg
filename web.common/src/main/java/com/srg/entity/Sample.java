package com.srg.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sample")
public class Sample {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Sample(String name) {
        this.name = name;
    }
}

package com.acme.graduates.demo.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "graduates")
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer year;

    @NotNull
    private String sex;

    @NotNull
    private String typeCourse;

    @NotNull
    private  Integer noGraduates;

}

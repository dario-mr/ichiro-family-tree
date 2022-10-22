package com.dario.ift.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@EqualsAndHashCode(of = {"name", "dateOfBirth"})
public class Dog implements Serializable {

    String name;
    String gender;
    String country;
    LocalDate dateOfBirth;
    String color;
    String imageUrl;
    String profileUrl;
    int generation;

    Dog mother;
    Dog father;

}

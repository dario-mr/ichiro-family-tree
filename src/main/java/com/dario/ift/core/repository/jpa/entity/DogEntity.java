package com.dario.ift.core.repository.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DOG", schema = "ICHIRO")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class DogEntity {

    @Id
    @Column(name = "DOG_ID")
    private Long id;

    @Column(name = "DOG_NAME")
    private String name;

    @Column(name = "DOG_GENDER")
    private String gender;

    @Column(name = "DOG_COUNTRY")
    private String country;

    @Column(name = "DOG_DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "DOG_COLOR")
    private String color;

    @Column(name = "DOG_IMAGE_URL")
    private String imageUrl;

    @Column(name = "DOG_PROFILE_URL")
    private String profileUrl;

    @Column(name = "DOG_GENERATION")
    private Integer generation;

    @OneToOne
    @JoinColumn(name = "DOG_MOTHER_ID", referencedColumnName = "DOG_ID")
    private DogEntity mother;

    @OneToOne
    @JoinColumn(name = "DOG_FATHER_ID", referencedColumnName = "DOG_ID")
    private DogEntity father;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DogEntity that = (DogEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

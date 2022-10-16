package com.dario.ift.core.repository.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TEST_TABLE", schema = "ICHIRO")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class TestEntity {

    @Id
    @Column(name = "TT_ID")
    private Long id;

    @Column(name = "TT_NAME")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TestEntity that = (TestEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

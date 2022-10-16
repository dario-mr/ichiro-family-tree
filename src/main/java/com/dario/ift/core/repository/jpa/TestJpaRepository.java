package com.dario.ift.core.repository.jpa;

import com.dario.ift.core.repository.jpa.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}

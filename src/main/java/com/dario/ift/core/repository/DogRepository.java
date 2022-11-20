package com.dario.ift.core.repository;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.repository.jpa.DogJpaRepository;
import com.dario.ift.core.repository.jpa.entity.DogEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.dario.ift.config.CacheConfig.DOG_FIND_BY_NAME;

@Repository
@RequiredArgsConstructor
public class DogRepository {

    private final DogJpaRepository dogJpaRepository;

    @Cacheable(DOG_FIND_BY_NAME)
    public Optional<Dog> findByName(String name) {
        return dogJpaRepository.findByName(name)
                .map(this::toDomain);
    }

    private Dog toDomain(DogEntity entity) {
        return Dog.builder()
                .name(entity.getName())
                .gender(entity.getGender())
                .country(entity.getCountry())
                .dateOfBirth(entity.getDateOfBirth())
                .color(entity.getColor())
                .imageUrl(entity.getImageUrl())
                .profileUrl(entity.getProfileUrl())
                .generation(entity.getGeneration())
                .mother(entity.getMother() == null ? null : toDomain(entity.getMother()))
                .father(entity.getFather() == null ? null : toDomain(entity.getFather()))
                .build();
    }

}

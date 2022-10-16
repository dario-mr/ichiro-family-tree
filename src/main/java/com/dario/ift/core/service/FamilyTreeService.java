package com.dario.ift.core.service;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FamilyTreeService {

    private final DogRepository dogRepository;

    public Dog getFamilyTree(int generations) {
        Dog ichiro = dogRepository.getFamilyTree();
        limitFamilyTreeDepth(ichiro, generations);

        return ichiro;
    }

    public Dog getDog(int generations) {
        String dogName = "Ichiro Go Takimisou";
        Dog ichiro = dogRepository.findByName(dogName)
                .orElseThrow(() -> new EntityNotFoundException(format("Dog [%s] not found", dogName)));

        limitFamilyTreeDepth(ichiro, generations);

        return ichiro;
    }

    private void limitFamilyTreeDepth(Dog dog, int generations) {
        if (dog.getGeneration() < generations && dog.getFather() != null && dog.getMother() != null) {
            limitFamilyTreeDepth(dog.getFather(), generations);
            limitFamilyTreeDepth(dog.getMother(), generations);
        } else {
            dog.setFather(null);
            dog.setMother(null);
        }
    }

}

package com.example.demo2;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TempHandler {

    private final TempRepository repository;

    public TempHandler(TempRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void handle(Long tempId) {
        Temp temp = repository.findById(tempId).orElseThrow();
        temp.updateName("updatedName");
        repository.save(temp);
    }
}

package com.example.demo2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TempService {

    private final TempRepository tempRepository;

    public TempService(TempRepository tempRepository) {
        this.tempRepository = tempRepository;
    }

    @Transactional
    public void saveTemp(Long id) {
        Temp temp = tempRepository.findById(id).orElseThrow();
        temp.onTest();
        Temp save = tempRepository.save(temp);
        System.out.println("save = " + save);
    }

    public void getTemp(Long id) {
        Temp temp = tempRepository.findById(id).orElseThrow();
        System.out.println("temp = " + temp.getId() + ", " + temp.getName() + ", " + temp.getAge());
    }
}

package com.example.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TempServiceTest {

    @Autowired
    private TempService tempService;

    @Autowired
    private TempRepository repository;

    @Test
    void name() {
        Temp temp = repository.save(new Temp("testName2"));
        temp.onTest();

        repository.save(temp);
    }
}

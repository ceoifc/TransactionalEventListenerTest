package com.example.demo2;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TempListener {

    private final TempHandler tempHandler;

    public TempListener(TempHandler tempHandler) {
        this.tempHandler = tempHandler;
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void listen(TempEvent event) {
        System.out.println("event = " + event.temp().getName());
        tempHandler.handle(event.temp().getId());
        if (!event.temp().getName().isEmpty()) {
            throw new RuntimeException("Name should be empty");
        }
    }
}

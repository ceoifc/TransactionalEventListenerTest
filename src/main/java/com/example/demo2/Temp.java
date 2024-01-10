package com.example.demo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Temp extends AbstractAggregateRoot<Temp> {

    public Temp() {

    }

    public Temp(String name) {
        this.name = name;
        this.age = 0;
    }

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int age;

    public void onTest() {
        this.age++;
        registerEvent(new TempEvent(this));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

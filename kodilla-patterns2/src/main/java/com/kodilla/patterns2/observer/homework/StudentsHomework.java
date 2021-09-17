package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StudentsHomework implements Observable{
    private final ArrayDeque<String> homework;
    private final List<Observer> observer;
    private final String name;

    public StudentsHomework(String name) {
        this.name = name;
        this.homework = new ArrayDeque<>();
        this.observer = new ArrayList<>();
    }
    public void sendHomework(String string){
        homework.offer(string);
        notifyObserver();
    }
    @Override
    public void notifyObserver(){
        for (Observer mentor:observer) {
            mentor.update(this);
        }
    }
    @Override
    public void registerObserver(Observer observer){
        this.observer.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        this.observer.remove(observer);
    }

    public ArrayDeque<String> getHomework() {
        return homework;
    }

    public String getName() {
        return name;
    }
}

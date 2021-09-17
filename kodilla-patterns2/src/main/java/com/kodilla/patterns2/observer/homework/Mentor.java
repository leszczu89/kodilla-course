package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String name;
    private int homeworksToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(StudentsHomework studentsHomework){
        System.out.println(name + ": New work to check from student: "+ studentsHomework.getName());
        homeworksToCheck++;
        System.out.println("Total number of homeworks to correct: "+ homeworksToCheck);
    }

    public String getName() {
        return name;
    }

    public int getHomeworksToCheck() {
        return homeworksToCheck;
    }
}

package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsHomeworkTestSuite {
    @Test
    void testUpdate(){
        //Given
        Mentor firstMentor = new Mentor("FirstMentor");
        Mentor secondMentor = new Mentor("SecondMentor");

        StudentsHomework firstStudent = new StudentsHomework("Student1");
        StudentsHomework secondStudent = new StudentsHomework("Student2");
        StudentsHomework thirdStudent = new StudentsHomework("Student3");
        StudentsHomework fourthStudent = new StudentsHomework("Student4");

        firstStudent.registerObserver(firstMentor);
        secondStudent.registerObserver(secondMentor);
        thirdStudent.registerObserver(firstMentor);
        fourthStudent.registerObserver(secondMentor);

        //When
        firstStudent.sendHomework("Test1");
        firstStudent.sendHomework("Test2");
        secondStudent.sendHomework("Test1");
        secondStudent.sendHomework("Test2");
        thirdStudent.sendHomework("Added class");
        thirdStudent.sendHomework("Removed class");
        fourthStudent.sendHomework("Fixed");

        //Then
        assertEquals(4, firstMentor.getHomeworksToCheck());
        assertEquals(3, secondMentor.getHomeworksToCheck());

    }

}
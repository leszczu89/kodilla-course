package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTaskFactory() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        //Then
        assertEquals("Food shopping",shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());
        shoppingTask.executeTask();
        assertTrue(shoppingTask.isTaskExecuted());
    }
    @Test
    void testPaintingTaskFactory() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        //Then
        assertEquals("House painting", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecuted());
        paintingTask.executeTask();
        assertTrue(paintingTask.isTaskExecuted());
    }
    @Test
    void testDrivingTaskFactory() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        //Then
        assertEquals("Give a lift", drivingTask.getTaskName());
        assertFalse(drivingTask.isTaskExecuted());
        drivingTask.executeTask();
        assertTrue(drivingTask.isTaskExecuted());
    }
}

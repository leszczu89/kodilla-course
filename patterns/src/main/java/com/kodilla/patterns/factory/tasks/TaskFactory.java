package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Food shopping", "eggs", 10.0);
            case PAINTING_TASK:
                return new PaintingTask("House painting", "Blue", "Kitchen");
            case DRIVING_TASK:
                return new DrivingTask("Give a lift", "To home", "Rented car");
            default:
                return null;
        }
    }
}

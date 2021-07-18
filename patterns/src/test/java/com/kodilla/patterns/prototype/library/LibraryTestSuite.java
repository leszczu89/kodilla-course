package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        //Given
        Library library = new Library("Prototype library");
        library.books.add(new Book("First book", "First author", LocalDate.of(1999, 12, 1)));
        library.books.add(new Book("Second book", "Second author", LocalDate.of(2012, 1, 12)));
        library.books.add(new Book("Third book", "Third author", LocalDate.of(2020, 5, 3)));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow cloned library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep cloned library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("\nLibraries before addition: ");
        System.out.println(library.getName() +"\n"+library.books);
        System.out.println(shallowClonedLibrary.getName() +"\n"+shallowClonedLibrary.books);
        System.out.println(deepClonedLibrary.getName() +"\n"+deepClonedLibrary.books);

        //When
        library.books.add(new Book("New title", "New author", LocalDate.now()));
        System.out.println("\nLibraries after addition: ");
        System.out.println(library.getName() +"\n"+library.books);
        System.out.println(shallowClonedLibrary.getName() +"\n"+shallowClonedLibrary.books);
        System.out.println(deepClonedLibrary.getName() +"\n"+deepClonedLibrary.books);
        //Then
        assertEquals(4, library.books.size());
        assertEquals(4, shallowClonedLibrary.books.size());
        assertEquals(3, deepClonedLibrary.books.size());
        assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}

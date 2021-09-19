package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
       //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("A", "T", 2002, "012"));
        books.add(new Book("Author", "Title", 2020, "123"));
        books.add(new Book("First", "Second", 2010, "234"));
        books.add(new Book("One", "Two", 1989, "564"));
        books.add(new Book("Uno", "Dos", 1999, "256"));

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int medianResult = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(2002, medianResult);

    }
}

package com.project.Books.controllers;

import com.project.Books.adapters.BookAdapter;
import com.project.Books.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BookControllerTest {

    private BookAdapter victim;
    private Book book;

    @Before
    public void setup() {
        victim = new BookAdapter();
        book = new Book();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse("07-03-2019");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book.setId();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setPublished(date);
        book.setPages(99);
        book.setISBN("ISBN");
    }

    @Test
    public void addNewBookWhenDatesAreCorrect() {

        assertEquals(book, victim.getBookData("Title,Author,07-03-2019,99,ISBN"));

    }

    @Test
    public void addNewBookWhenDatesAreWrong() {

        assertNull(victim.getBookData("Title,Author,09-09"));
        assertNull(victim.getBookData("Title,Author,09-09-2019,10A,ISBN"));

    }

}
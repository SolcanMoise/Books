package com.project.Books.adapters;

import com.project.Books.models.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Adapter class for Book class.
 * @author solcanm
 * @date 19 June 2019
 */
public class BookAdapter {

    public Book getBookData(String dates) {

        Book book = new Book();
        String[] fields = dates.split(",");
        try{
            Book.setId();

            book.setTitle(fields[0]);

            book.setAuthor(fields[1]);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(fields[2]);
            book.setPublished(date);

            Integer pages = Integer.parseInt(fields[3]);
            book.setPages(pages);

            book.setISBN(fields[4]);

        } catch (ParseException | NumberFormatException e) {
            return null;
        }

        return book;
    }

}

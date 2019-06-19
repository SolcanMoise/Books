package com.project.Books.controllers;

import com.project.Books.adapters.BookAdapter;
import com.project.Books.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Represents a controller for application
 * @author solcanm
 * @date 16 June 2019
 */

@Service
@RequestMapping(value = "/book")
public class BookController {

    private BookAdapter adapter = new BookAdapter();

    @GetMapping(path="/addNewBook") // Map ONLY GET Requests
    public @ResponseBody
    String addNewBook (@RequestParam String dates) {

        Book book = adapter.getBookData(dates);

        return null;

    }

}

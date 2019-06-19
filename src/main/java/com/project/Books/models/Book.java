package com.project.Books.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a book.
 * @author solcanm
 * @date 16 June 2019
 */

public class Book {

    private Integer id;

    private String tile;

    private String author;

    private Date published;

    private Integer pages;

    private String ISBN;

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(tile, book.tile) &&
                Objects.equals(author, book.author) &&
                Objects.equals(published, book.published) &&
                Objects.equals(pages, book.pages) &&
                Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tile, author, published, pages, ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tile='" + tile + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", pages=" + pages +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

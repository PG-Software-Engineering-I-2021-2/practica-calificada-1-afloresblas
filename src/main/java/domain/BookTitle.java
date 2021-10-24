package domain;

import java.util.ArrayList;
import java.util.List;

public class BookTitle {
    String name;
    String year;
    Author author;
    List<BookCopy> copies;


    public BookTitle(String name, String year, Author author) {
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }


    public Author getAuthor() {
        return author;
    }


    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }
}

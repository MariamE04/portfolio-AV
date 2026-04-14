package searchandsort.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book implements Comparable<Book> {

    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    // Comparable → bruges af TreeSet
    @Override
    public int compareTo(Book other) {
        return this.isbn.compareTo(other.isbn);
    }

    // equals → bruges af HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    // hashCode → bruges af HashSet
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', isbn='" + isbn + "'}";
    }

    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        books.add(new Book("Java", "123"));
        books.add(new Book("Python", "456"));

        System.out.println(books.contains(new Book("Test", "123")));
    }
}
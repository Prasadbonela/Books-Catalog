package com.epam.rd.autotasks.collections.map;

import java.util.*;

public class BooksCatalog {
    private static final String EOL = "\n";
    private TreeMap<Author, List<Book>> catalog;

    public BooksCatalog() {
        this.catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        this.catalog = new TreeMap<>(catalog);
    }

    public List<Book> findByAuthor(Author author) {
        Objects.requireNonNull(author, "Author cannot be null");
        return catalog.getOrDefault(author, null);
    }

    public List<Author> findAuthorsByBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");
        List<Author> authors = new ArrayList<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            if (entry.getValue().contains(book)) {
                authors.add(entry.getKey());
            }
        }
        return authors.isEmpty() ? null : authors;
    }

    public String getAllAuthors() {
        TreeSet<Author> sortedAuthors = new TreeSet<>(catalog.keySet());
        StringBuilder result = new StringBuilder();
        for (Author author : sortedAuthors) {
            result.append(author.getFirstName()).append(" ").append(author.getLastName()).append(EOL);
        }
        return result.toString().trim();
    }

    public Set<Book> findBooksByGenre(String pattern) {
        Objects.requireNonNull(pattern, "Pattern cannot be null");
        TreeSet<Book> books = new TreeSet<>();
        for (List<Book> bookList : catalog.values()) {
            for (Book book : bookList) {
                for (String genre : book.getGenres()) {
                    if (genre.toLowerCase().contains(pattern.toLowerCase())) {
                        books.add(book);
                        break;
                    }
                }
            }
        }
        return books.isEmpty() ? null : books;
    }

    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        Objects.requireNonNull(pattern, "Pattern cannot be null");
        TreeMap<Book, List<Author>> result = new TreeMap<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.getTitle().toLowerCase().contains(pattern.toLowerCase())) {
                    result.putIfAbsent(book, new ArrayList<>());
                    result.get(book).add(entry.getKey());
                }
            }
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(EOL);
        }
        return result.toString().trim();
    }
}

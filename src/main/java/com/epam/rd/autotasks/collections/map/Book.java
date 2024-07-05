package com.epam.rd.autotasks.collections.map;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private List<String> genres;
    private BigDecimal cost;

    public Book(String title, List<String> genres, BigDecimal cost) {
        this.title = title;
        this.genres = genres;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public int compareTo(Book other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return this.cost.compareTo(other.cost);
    }

    @Override
    public String toString() {
        return title + " (" + cost + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && cost.equals(book.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }
}

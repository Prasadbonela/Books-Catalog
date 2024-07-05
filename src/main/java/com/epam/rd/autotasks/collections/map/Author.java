package com.epam.rd.autotasks.collections.map;

import java.util.Objects;

public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Author other) {
        int firstNameComparison = this.firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return firstName.equals(author.firstName) && lastName.equals(author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

package com.library.management.domain;

/*import jakarta.persistence.*;
import jakarta.validation.constraints.*;*/

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated unique book ID

    @NotBlank(message = "Title must not be blank")
    @Size(max = 100, message = "Title can't exceed 100 characters")
    private String title;

    @NotBlank(message = "Author must not be blank")
    @Size(max = 100, message = "Author name can't exceed 100 characters")
    private String author;

    @NotBlank(message = "ISBN must not be blank")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number")
    private String isbn;

    @Min(value = 1, message = "Total copies must be at least 1")
    private int totalCopies;

    @Min(value = 0, message = "Available copies cannot be negative")
    private int availableCopies;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, int totalCopies, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    // Getters and Setters...

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}

package pl.coderslab.models;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
public class Book {
    private Integer id;

    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getIsbn().equals(book.getIsbn()) &&
                getTitle().equals(book.getTitle()) &&
                getAuthor().equals(book.getAuthor()) &&
                getPublisher().equals(book.getPublisher()) &&
                getType().equals(book.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getTitle(), getAuthor(), getPublisher(), getType());
    }
}

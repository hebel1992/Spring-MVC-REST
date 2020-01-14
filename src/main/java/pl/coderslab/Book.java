package pl.coderslab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;

    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private String type;
}

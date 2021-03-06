package pl.coderslab.repositories;

import org.springframework.stereotype.Service;
import pl.coderslab.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService<Book, Integer> {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getAllElements() {
        return list;
    }

    @Override
    public Book getOneElement(Integer id) {
        Optional<Book> book = list.stream()
                .filter(e -> e.getId() == id)
                .findAny();
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public Book addElement(Book book) {
        list.add(book);
        return book;
    }

    @Override
    public Book updateElement(Book book) {
        Book existingBook = getOneElement(book.getId());
        if (existingBook != null) {
            list.set(list.indexOf(existingBook), book);
        }
        return book;
    }

    @Override
    public Book deleteElement(Integer id) {
        Book book = getOneElement(id);
        if (book != null) {
            list.remove(book);
            return book;
        }
        return null;
    }
}

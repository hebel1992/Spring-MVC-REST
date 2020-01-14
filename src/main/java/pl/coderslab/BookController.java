package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    //test method
    @GetMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @GetMapping("/helloBook")
    public Book helloBook() {
        return new Book(1, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/")
    public List<Book> allBooks() {
        List<Book> books = memoryBookService.getList();
        return books;
    }

    //book sent from postman and saved in books
    @PostMapping(value = "/addBook")
    @ResponseBody
    public Book book(@RequestBody Book book) {
        memoryBookService.addBook(book);
        return book;
    }

    @GetMapping("/{id}")
    public Book book(@PathVariable Integer id) {
        return memoryBookService.getBook(id);
    }
}

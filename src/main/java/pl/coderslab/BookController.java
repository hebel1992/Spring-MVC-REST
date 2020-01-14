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
        List<Book> books = memoryBookService.getAllElements();
        return books;
    }

    @GetMapping("/{id}")
    public Book book(@PathVariable Integer id) {
        return memoryBookService.getOneElement(id);
    }

    @PostMapping(value = "/addBook")
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return memoryBookService.addElement(book);
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return memoryBookService.updateElement(book);
    }

    @DeleteMapping(value = "/deleteBook/{id}")
    public Book removeBook(@PathVariable Integer id) {
        return memoryBookService.deleteElement(id);
    }
}

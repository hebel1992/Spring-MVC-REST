package pl.coderslab.controlleres;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/")
    public String home() {
        return "Home Page";
    }
}

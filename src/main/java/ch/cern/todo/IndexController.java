package ch.cern.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index"; // Assuming "index" is the name of your HTML file (e.g., index.html)
    }
}
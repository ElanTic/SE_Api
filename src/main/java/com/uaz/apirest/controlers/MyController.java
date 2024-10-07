package controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Inicio");
        return "index";
    }

    @GetMapping("/partial")
    public String partialContent(Model model) {
        return "fragments :: contentFragment";
    }
}
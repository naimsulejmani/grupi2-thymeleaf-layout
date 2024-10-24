package dev.naimsulejmani.grupi2thymeleaflayout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    private LocalDateTime startedDate = LocalDateTime.now();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Home Page");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Page");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        System.out.println("Testing2");
        model.addAttribute("pageTitle", "Contact Page");
        return "contact";
    }


    @GetMapping("/random")
    public String random(Model model) {
        model.addAttribute("pageTitle", "Random Page");
        double random = Math.random();
        if (random < 0.334) {
            return "index";
        } else if (random < 0.667) {
            return "about";
        } else {
            return "contact";
        }
    }

    // time page
    @GetMapping("/time")
    public String time(Model model) {
        model.addAttribute("pageTitle", "Time Page");
        model.addAttribute("serverStarted", startedDate);
        model.addAttribute("currentTime", LocalDateTime.now());
        return "time";
    }
}



















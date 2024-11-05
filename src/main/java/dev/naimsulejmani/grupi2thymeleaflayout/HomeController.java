package dev.naimsulejmani.grupi2thymeleaflayout;

import dev.naimsulejmani.grupi2thymeleaflayout.models.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private LocalDateTime startedDate = LocalDateTime.now();
    private List<News> news = new ArrayList<>();

    public HomeController() {
        news.add(new News("images/1.jpg", "Simple Date", "Dont play with different formats", LocalDate.now(), "DEVS", LocalDateTime.now()));
        news.add(new News("images/2.jpg", "Movie 1", "Dont act as a Hacker", LocalDate.now(), "IT", LocalDateTime.now()));
        news.add(new News("images/3.jpg", "White fear", "White attracts bugs", LocalDate.now(), "DEVS", LocalDateTime.now()));
    }

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

        model.addAttribute("random", random);

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
        double random = Math.random();
        model.addAttribute("random", random);
        return "time";
    }

    @GetMapping("/loop")
    public String loop(Model model) {
        model.addAttribute("start", 1);
        model.addAttribute("end", 10);
        model.addAttribute("news", news);
        return "loop";
    }

}



















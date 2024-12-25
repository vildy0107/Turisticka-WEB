package projekat.webTA.Controlllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start {
    @GetMapping("/") // Handle the root URL
    public String home() {
        return "home"; // Return the home view
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        // Pass data to the view if needed
        model.addAttribute("message", "Welcome to the Putnik Course Management System");
        return "welcome";  // This maps to the "welcome.html" view
    }
}

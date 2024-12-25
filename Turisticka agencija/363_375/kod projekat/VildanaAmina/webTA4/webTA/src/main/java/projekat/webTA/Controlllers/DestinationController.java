package projekat.webTA.Controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projekat.webTA.Models.Destination;
import projekat.webTA.Models.User;
import projekat.webTA.Repositories.UserRepository;
import projekat.webTA.Services.DestinationService;

import java.security.Principal;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/destinations")
    public String showDestinations(Model model) {
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "destinations";
    }

    @PostMapping("/choose-destination")
    public String chooseDestination(@RequestParam String destinationName, Principal principal) {
        if (principal != null) {
            User user = userRepository.findByUsername(principal.getName()).orElseThrow();
            // Postavljanje naziva destinacije direktno preko podataka poslanih s frontenda
            user.setSelectedDestination(destinationName);
            userRepository.save(user);
        }
        // salje na welcome stranicu jer nema trenutno one dashboard pa vratite na njega kada dodate
        return "redirect:/welcome";
    }
}

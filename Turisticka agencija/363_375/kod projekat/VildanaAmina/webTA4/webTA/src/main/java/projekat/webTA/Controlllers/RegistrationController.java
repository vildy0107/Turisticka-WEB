package projekat.webTA.Controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projekat.webTA.Models.User;
import projekat.webTA.Repositories.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registracija";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // If the user provided a role, ensure it doesn't have the "ROLE_" prefix
        if (user.getRole() != null) {
            user.setRole(user.getRole().replace("ROLE_", "").trim());
        }

        // If no role is provided or the role is empty, set a default "USER" role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        // Save the user to the repository
        userRepository.save(user);

        model.addAttribute("successMessage", "Registration successful. You can now login.");
        return "redirect:/login";
    }
}

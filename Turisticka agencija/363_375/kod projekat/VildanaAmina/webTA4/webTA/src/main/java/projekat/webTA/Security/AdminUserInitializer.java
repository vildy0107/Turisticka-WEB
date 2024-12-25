package projekat.webTA.Security;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import projekat.webTA.Models.User;
import projekat.webTA.Repositories.UserRepository;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; // Prava instanca repository-ja

    @Autowired
    private PasswordEncoder passwordEncoder; // Korišćenje PasswordEncoder-a

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Proverite da li admin korisnik već postoji
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123")); // Promenjena šifra na "1"
            admin.setRole("ADMIN"); // Uloga "ADMIN"
            userRepository.save(admin);  // Spasi novog admina
            System.out.println("Korisničko ime: 'admin', šifra: 'admin123'");
        } else {
            System.out.println("Admin korisnik već postoji.");
        }
    }
}

package projekat.webTA.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class Putnik {

    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Annotation for validating fields
    @NotEmpty(message = "Upiši ime")
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @NotEmpty(message = "Upiši email")
    @Email(message = "Unesi ispravnu email adresu")
    private String email;

    // Constructors
    public Putnik() {}

    public Putnik(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

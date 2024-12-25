package projekat.webTA.Controlllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projekat.webTA.Models.Putnik;
import projekat.webTA.Services.PutnikService;

import java.util.List;

@Controller
@RequestMapping("/putnici")
public class PutnikController {

    @Autowired
    private PutnikService putnikService;

    @GetMapping
    public String listPutnici(Model model) {
        model.addAttribute("putnici", putnikService.findAllPutnici());
        return "admin_tabela";
    }

    @GetMapping("/new")
    public String showAddPutnikForm(Model model) {
        model.addAttribute("putnik", new Putnik());
        return "dodaj_putnika";
    }

    @PostMapping("/new")
    public String addPutnik(
            @Valid @ModelAttribute Putnik putnik,
            BindingResult result, // Ensure this is immediately after @Valid
            @RequestParam(value = "courseIds", required = false) List<Long> courseIds,
            Model model
    ) {
        if (result.hasErrors()) {
            return "dodaj_putnika";
        }

        putnikService.savePutnik(putnik, courseIds);
        return "redirect:/putnici";
    }

    @GetMapping("/edit/{id}")
    public String showEditPutnikForm(@PathVariable Long id, Model model) {
        Putnik putnik = putnikService.findPutnikById(id).orElse(null);
        if (putnik == null) {
            return "redirect:/putnici";
        }
        model.addAttribute("putnik", putnik);
        return "azuriraj_putnika";
    }

    @PostMapping("/edit")
    public String editPutnik(
            @Valid @ModelAttribute Putnik putnik,
            BindingResult result,
            @RequestParam(value = "courseIds", required = false) List<Long> courseIds,
            Model model
    ) {
        if (result.hasErrors()) {
            return "azuriraj_putnika"; // Display form with validation messages
        }

        putnikService.updatePutnik(putnik, courseIds);
        return "redirect:/putnici";
    }

    @GetMapping("/delete/{id}")
    public String deletePutnik(@PathVariable Long id) {
        putnikService.deletePutnik(id);
        return "redirect:/putnici";
    }
}

package projekat.webTA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekat.webTA.Models.Putnik;
import projekat.webTA.Repositories.PutnikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PutnikService {

    @Autowired
    private PutnikRepository putnikRepository;

    @Autowired
    public List<Putnik> findAllPutnici() {
        return putnikRepository.findAll();
    }

    public Optional<Putnik> findPutnikById(Long id) {
        return putnikRepository.findById(id);
    }

    public Putnik savePutnik(Putnik putnik, List<Long> courseIds) {
        if (courseIds != null) {
            for (Long courseId : courseIds) {
                // Handling course assignments if needed
            }
        }
        return putnikRepository.save(putnik);
    }

    public Putnik updatePutnik(Putnik updatedPutnik, List<Long> courseIds) {
        // Retrieve the existing putnik by ID
        Optional<Putnik> existingPutnikOpt = putnikRepository.findById(updatedPutnik.getId());
        if (existingPutnikOpt.isEmpty()) {
            throw new IllegalArgumentException("Putnik with ID " + updatedPutnik.getId() + " not found.");
        }

        Putnik existingPutnik = existingPutnikOpt.get();

        // Update fields of the existing putnik
        existingPutnik.setName(updatedPutnik.getName());
        existingPutnik.setEmail(updatedPutnik.getEmail());

        // Clear and re-add courses if necessary
        if (courseIds != null) {
            for (Long courseId : courseIds) {
                // Handling course assignments if needed
            }
        }

        return putnikRepository.save(existingPutnik);
    }

    public void deletePutnik(Long id) {
        putnikRepository.deleteById(id);
    }
}

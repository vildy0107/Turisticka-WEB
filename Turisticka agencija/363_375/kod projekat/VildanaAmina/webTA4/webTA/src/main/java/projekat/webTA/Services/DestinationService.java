package projekat.webTA.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekat.webTA.Models.Destination;
import projekat.webTA.Repositories.DestinationRepository;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }
}

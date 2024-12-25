package projekat.webTA.Security;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import projekat.webTA.Models.Destination;
import projekat.webTA.Services.DestinationService;

@Component
public class DestinationInitializer implements CommandLineRunner {

    private final DestinationService destinationService;

    public DestinationInitializer(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @Override
    public void run(String... args) throws Exception {
        destinationService.saveDestination(new Destination("Paris", "https://images.unsplash.com/photo-1502602898657-3e91760cbb34"));
        destinationService.saveDestination(new Destination("Rome", "https://images.unsplash.com/photo-1546539782-6fc531453083"));
        destinationService.saveDestination(new Destination("Santorini", "https://images.unsplash.com/photo-1505739773414-73a9c7f2aab5"));
        destinationService.saveDestination(new Destination("Istanbul", "https://images.unsplash.com/photo-1554892308-5bccd82aeb1f"));
        destinationService.saveDestination(new Destination("Oslo", "https://images.unsplash.com/photo-1558085292-4bd221e6e964"));
        destinationService.saveDestination(new Destination("Prague", "https://images.unsplash.com/photo-1544378937-86ecae3a36c2"));
    }
}

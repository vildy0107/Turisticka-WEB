package projekat.webTA.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projekat.webTA.Models.Putnik;

@Repository
public interface PutnikRepository extends JpaRepository<Putnik, Long> {
    // JpaRepository provides built-in CRUD methods, so no additional methods are necessary here for basic operations.
}



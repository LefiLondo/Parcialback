package parcial.backend.demo.repository;

import parcial.backend.demo.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findByIdlibro(Long idlibro);  
}

package parcial.backend.demo.service;

import parcial.backend.demo.entity.Libro;
import parcial.backend.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Método para buscar un libro por su ID
    public Libro findLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    // Método para guardar o actualizar un libro
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Método para eliminar un libro por su ID
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    // Método para listar todos los libros
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }
}

package parcial.backend.demo.controller;

import parcial.backend.demo.entity.Libro;
import parcial.backend.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Agregar un nuevo libro
    @PostMapping("/agregarlibro")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.saveLibro(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    // Actualizar un libro existente
    @PutMapping("/actualizarlibro/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setIdlibro(id);
        Libro libroActualizado = libroService.saveLibro(libro);
        return ResponseEntity.ok(libroActualizado);
    }

    // Eliminar un libro por su ID
    @DeleteMapping("/eliminarlibro/{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.ok().build();
    }

    // Obtener un libro por su ID
    @GetMapping("/buscarlibro/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {
        Libro libro = libroService.findLibroById(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos los libros
    @GetMapping("/listarlibros")
    public ResponseEntity<Iterable<Libro>> listarLibros() {
        Iterable<Libro> lista = libroService.findAllLibros();
        return ResponseEntity.ok(lista);
    }
}

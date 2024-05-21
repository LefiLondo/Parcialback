package parcial.backend.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import parcial.backend.demo.model.Arrendatario;


public interface ArrendatarioRepository  extends JpaRepository<Arrendatario, Long>{

    Arrendatario findByIdArrendatario(Long idArrendatario);

    Optional <Arrendatario> findBycorreoElectronico(String correoElectronico);
}

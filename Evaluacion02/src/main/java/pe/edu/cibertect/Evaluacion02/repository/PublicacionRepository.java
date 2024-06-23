package pe.edu.cibertect.Evaluacion02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertect.Evaluacion02.model.bd.Publicacion;

@Repository
public interface PublicacionRepository
        extends JpaRepository<Publicacion, Integer> {

}

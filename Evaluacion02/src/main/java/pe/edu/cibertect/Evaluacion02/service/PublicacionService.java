package pe.edu.cibertect.Evaluacion02.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertect.Evaluacion02.model.bd.Publicacion;
import pe.edu.cibertect.Evaluacion02.repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PublicacionService implements IPublicacionService {
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> listarPublicacion() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion guardarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Optional<Publicacion> obtenerPublicacionxId(Integer id) {
        Optional<Publicacion> publicacion
                = publicacionRepository.findById(id);
        if(publicacion.isEmpty()){
            return Optional.empty();
        }
        return publicacion;
    }

}

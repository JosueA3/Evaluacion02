package pe.edu.cibertect.Evaluacion02.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertect.Evaluacion02.model.bd.Autor;
import pe.edu.cibertect.Evaluacion02.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService {
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> obtenerAutorxId(Integer id) {

        Optional<Autor> autor
                = autorRepository.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return autor;
    }

}

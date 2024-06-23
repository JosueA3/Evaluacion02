package pe.edu.cibertect.Evaluacion02.service;

import pe.edu.cibertect.Evaluacion02.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutor();
    Autor guardarAutor(Autor autor);
    Optional<Autor> obtenerAutorxId(Integer id);
}

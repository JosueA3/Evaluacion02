package pe.edu.cibertect.Evaluacion02.service;

import pe.edu.cibertect.Evaluacion02.model.bd.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    List<Publicacion> listarPublicacion();
    Publicacion guardarPublicacion(Publicacion publicacion);
    Optional<Publicacion> obtenerPublicacionxId(Integer id);
}

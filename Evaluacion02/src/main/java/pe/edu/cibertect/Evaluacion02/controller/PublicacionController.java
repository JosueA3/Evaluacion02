package pe.edu.cibertect.Evaluacion02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertect.Evaluacion02.exception.ResourceNotFoundException;
import pe.edu.cibertect.Evaluacion02.model.bd.Publicacion;
import pe.edu.cibertect.Evaluacion02.service.PublicacionService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/publicacion")
public class PublicacionController {

    private PublicacionService publicacionService;

    @GetMapping("")
    public ResponseEntity<List<Publicacion>> listarPublicacion(){
        List<Publicacion> publicacionList = new ArrayList<>(publicacionService.listarPublicacion());
        if(publicacionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publicacionList, HttpStatus.OK);
    }

    @GetMapping("/{publicacion}")
    public ResponseEntity<Publicacion> obtenerAutorXId(
            @PathVariable Integer idpublicacion){
        Publicacion publicacion = publicacionService
                .obtenerPublicacionxId(idpublicacion).orElseThrow(
                        () -> new ResourceNotFoundException("La publicacion con Id " +
                                idpublicacion + " no existe"));
        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Publicacion> registrarPublicacion(
            @RequestBody Publicacion publicacion
    ){
        return new ResponseEntity<>(
                publicacionService.guardarPublicacion(publicacion), HttpStatus.CREATED);
    }

    @PutMapping("/{idpublicacion}")
    public ResponseEntity<Publicacion> actualizarPublicacion(
            @PathVariable Integer idpublicacion,
            @RequestBody Publicacion publicacion
    ){
        Publicacion newPublicacion = publicacionService.obtenerPublicacionxId(idpublicacion)
                .orElseThrow(() -> new ResourceNotFoundException("El Autor con Id "
                + idpublicacion +" no existe"));
        newPublicacion.setTitulo(publicacion.getTitulo());
        newPublicacion.setResumen(publicacion.getResumen());
        newPublicacion.setFechpublicacion(publicacion.getFechpublicacion());
        return new ResponseEntity<>(
                publicacionService.guardarPublicacion(newPublicacion),
                HttpStatus.OK);
    }



}

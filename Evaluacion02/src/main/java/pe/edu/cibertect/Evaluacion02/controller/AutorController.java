package pe.edu.cibertect.Evaluacion02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertect.Evaluacion02.exception.ResourceNotFoundException;
import pe.edu.cibertect.Evaluacion02.model.bd.Autor;
import pe.edu.cibertect.Evaluacion02.service.AutorService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/autor")
public class AutorController {

    private AutorService autorService;

    @GetMapping("")
    public ResponseEntity<List<Autor>> listarAutor(){
        List<Autor> autorList = new ArrayList<>(autorService.listarAutor());
        if(autorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(autorList, HttpStatus.OK);
    }

    @GetMapping("/{idautor}")
    public ResponseEntity<Autor> obtenerAutorXId(
            @PathVariable Integer idautor){
        Autor autor = autorService
                .obtenerAutorxId(idautor).orElseThrow(
                        () -> new ResourceNotFoundException("El autor con Id " +
                                idautor + " no existe"));
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Autor> registrarAutor(
            @RequestBody Autor autor
    ){
        return new ResponseEntity<>(
                autorService.guardarAutor(autor), HttpStatus.CREATED);
    }

    @PutMapping("/{idautor}")
    public ResponseEntity<Autor> actualizarAutor(
            @PathVariable Integer idautor,
            @RequestBody Autor autor
    ){
        Autor newAutor = autorService.obtenerAutorxId(idautor)
                .orElseThrow(() -> new ResourceNotFoundException("El Autor con Id "
                + idautor +" no existe"));
        newAutor.setNomAutor(autor.getNomAutor());
        newAutor.setApeautor(autor.getApeautor());
        newAutor.setFechnacautor(autor.getFechnacautor());
        return new ResponseEntity<>(
                autorService.guardarAutor(newAutor),
                HttpStatus.OK);
    }



}

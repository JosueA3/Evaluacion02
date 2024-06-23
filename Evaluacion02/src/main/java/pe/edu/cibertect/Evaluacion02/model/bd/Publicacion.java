package pe.edu.cibertect.Evaluacion02.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private String fechpublicacion;
    /*@ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;*/

}

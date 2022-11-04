package com.tiendaa.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity //para mapear a una base de datos
@Table(name = "categoria") //se va a mapear la tabla cliente de la base de datos

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la generacion del valor de id cliente se le delega al motor de la BD
    private Long idCategoria; //id_cliente en BD y en Java idCliente

    private String descripcion;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}

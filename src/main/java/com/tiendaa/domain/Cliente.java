package com.tiendaa.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity //para mapear a una base de datos
@Table(name = "cliente") //se va a mapear la tabla cliente de la base de datos

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la generacion del valor de id cliente se le delega al motor de la BD
    @Column(name = "id_cliente")
    private Long idCliente; //id_cliente en BD y en Java idCliente

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne //que tipo de relacion es
    private Credito credito;

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

    public Cliente() {
    }
}

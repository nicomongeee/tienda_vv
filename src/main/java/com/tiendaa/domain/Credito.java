package com.tiendaa.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity //para mapear a una base de datos
@Table(name = "credito") //se va a mapear la tabla cliente de la base de datos

public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la generacion del valor de id cliente se le delega al motor de la BD
    @Column(name = "id_credito") //que en la base se llama asi, para asociacion
    private Long idCredito; //id_cliente en BD y en Java idCliente

    public double limite;

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }

}

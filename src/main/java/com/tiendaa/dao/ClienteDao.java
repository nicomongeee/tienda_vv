package com.tiendaa.dao;

import com.tiendaa.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDao extends JpaRepository<Cliente,Long>{ //tiene todos los elementos para interactuar con la BD
    
}

package com.tiendaa.dao;

import com.tiendaa.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDao extends JpaRepository<Cliente,Long>{ //tiene todos los elementos para interactuar con la BD
    
    public List<Cliente> findByApellidos(String apellidos);
    
}

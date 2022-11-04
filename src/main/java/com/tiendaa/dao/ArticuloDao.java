package com.tiendaa.dao;

import com.tiendaa.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticuloDao extends JpaRepository<Articulo,Long>{ //tiene todos los elementos para interactuar con la BD
    
}

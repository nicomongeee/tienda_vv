package com.tiendaa.dao;

import com.tiendaa.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

//cnt h
public interface CreditoDao extends JpaRepository<Credito,Long>{ //tiene todos los elementos para interactuar con la BD
    
}

package com.tiendaa.services;

import com.tiendaa.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);
}

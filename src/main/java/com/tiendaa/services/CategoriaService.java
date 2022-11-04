package com.tiendaa.services;

import com.tiendaa.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
}

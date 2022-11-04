package com.tiendaa.services;

import com.tiendaa.dao.CategoriaDao;
import com.tiendaa.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //para que la clase se considere un servicio
public class CategoriaServiceImpl implements CategoriaService {

    //@Autowired provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private CategoriaDao categoriaDao;

    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean filtro) { //si es activo solo las categorias activas se debem mostrar
        var lista = (List<Categoria>) categoriaDao.findAll();

        if (filtro) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true) //mientras tenga el readonly no modifica en la BD
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) { //insertar o actualizar
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}

package com.tiendaa.services;

import com.tiendaa.dao.ArticuloDao;
import com.tiendaa.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //para que la clase se considere un servicio
public class ArticuloServiceImpl implements ArticuloService {

    //@Autowired provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private ArticuloDao articuloDao;

    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean filtro) {
        var lista = (List<Articulo>) articuloDao.findAll();

        if (filtro) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true) //mientras tenga el readonly no modifica en la BD
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) { //insertar o actualizar
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
}

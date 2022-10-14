package com.tiendaa.services;

import com.tiendaa.dao.ClienteDao;
import com.tiendaa.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //para que la clase se considere un servicio
public class ClienteServiceImpl implements ClienteService{
    
    //@Autowired provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private ClienteDao clienteDao;
    
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes(){
        return (List<Cliente>)clienteDao.findAll();
    }
    @Override
    @Transactional(readOnly = true) //mientras tenga el readonly no modifica en la BD
    public Cliente getCliente(Cliente cliente){
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Cliente cliente){ //insertar o actualizar
       clienteDao.save(cliente);
    }
    @Override
    @Transactional
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }
}

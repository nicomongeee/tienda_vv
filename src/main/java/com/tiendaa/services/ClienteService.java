package com.tiendaa.services;

import com.tiendaa.domain.Cliente;
import java.util.List;

public interface ClienteService {
    //metodos para hacer un CRUD
    //CREATE READ UPDATE DELETE

    public List<Cliente> getClientes();

    public List<Cliente> getClientesPorApellidos(String apellidos);

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}

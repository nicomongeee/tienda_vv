package com.tiendaa.controller;

import com.tiendaa.domain.Cliente;
import com.tiendaa.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired //Cuando yo genere o intente utilizar indexController
    //si existe clientedao que lo use sino que lo cree
    //inyeccion de dependencias

    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {

        var clientes = clienteService.getClientes(); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("clientes", clientes);

        return "/cliente/listado";
    }

    //mapeo de los recursos
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado"; //para redireccionar la ruta
    }

    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente); // va y hace un select en la tabla
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/elimina/{idCliente}")
    public String clienteElimina(Cliente cliente) {
        clienteService.delete(cliente); // va y hace un select en la tabla
        return "redirect:/cliente/listado";
    }
}

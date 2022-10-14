package com.tiendaa.controller;

import com.tiendaa.dao.ClienteDao;
import com.tiendaa.domain.Cliente;
import com.tiendaa.services.ClienteService;
import java.util.Arrays;
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

    //mapeo de los recursos
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/"; //para redireccionar la ruta
    }

    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente); // va y hace un select en la tabla
        model.addAttribute("cliente",cliente);
        return "modificarCliente"; 
    }
    
    @GetMapping("/cliente/elimina/{idCliente}")
    public String clienteElimina(Cliente cliente) {
        clienteService.delete(cliente); // va y hace un select en la tabla
        return "redirect:/"; 
    }
}

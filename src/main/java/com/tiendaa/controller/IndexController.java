package com.tiendaa.controller;

import com.tiendaa.dao.ClienteDao;
import com.tiendaa.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //Cuando yo genere o intente utilizar indexController
               //si existe clientedao que lo use sino que lo cree
               //inyeccion de dependencias
    
    private ClienteDao clienteDao;
    
    //mapeo de los recursos
    @GetMapping("/")
    public String inicio(Model model){
        var texto="Estamos en semana 4";
        model.addAttribute("saludo", texto);
        
        /*Cliente cliente1= new Cliente("Pedro", "Jimenez Retana","pjimenez@gmail.com", "8989-9898");
        Cliente cliente2= new Cliente("Juan", "Retana Jimenez","pretana@gmail.com", "7575-5575");
        Cliente cliente3= new Cliente("Nicole", "Monge Gamboa","nmongeg@gmail.com", "7119-7178");
        
        var clientes=Arrays.asList(cliente1,cliente2,cliente3);*/
        
        var clientes = clienteDao.findAll(); //hace selct de la tabla y devuelve un arraylist
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }  
}

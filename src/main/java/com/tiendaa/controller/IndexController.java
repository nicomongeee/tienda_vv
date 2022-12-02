package com.tiendaa.controller;

import com.tiendaa.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired //Cuando yo genere o intente utilizar indexController
    //si existe clientedao que lo use sino que lo cree
    //inyeccion de dependencias

    private ArticuloService articuloService;

    //mapeo de los recursos
    @GetMapping("/")
    public String inicio(Model model) {

        var articulos = articuloService.getArticulos(true);
        //hace select de la tabla y devuelve un arraylist

        model.addAttribute("articulos", articulos);

        return "index";
    }
}

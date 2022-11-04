package com.tiendaa.controller;

import com.tiendaa.domain.Articulo;
import com.tiendaa.services.ArticuloService;
import com.tiendaa.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {

    @Autowired //Cuando yo genere o intente utilizar indexController
    //si existe articulodao que lo use sino que lo cree
    //inyeccion de dependencias

    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var texto = "Estamos en semana 4";
        model.addAttribute("saludo", texto);

        var articulos = articuloService.getArticulos(false); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    //mapeo de los recursos
    @GetMapping("/articulo/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/articulo/modificar";
    }

    @PostMapping("/articulo/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado"; //para redireccionar la ruta
    }

    @GetMapping("/articulo/actualiza/{idArticulo}")
    public String articuloActualiza(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo); // va y hace un select en la tabla
        model.addAttribute("articulo", articulo);
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/articulo/modificar";
    }

    @GetMapping("/articulo/elimina/{idArticulo}")
    public String articuloElimina(Articulo articulo) {
        articuloService.delete(articulo); // va y hace un select en la tabla
        return "redirect:/articulo/listado";
    }
}

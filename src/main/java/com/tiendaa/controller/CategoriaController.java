package com.tiendaa.controller;

import com.tiendaa.domain.Categoria;
import com.tiendaa.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired //Cuando yo genere o intente utilizar indexController
    //si existe categoriadao que lo use sino que lo cree
    //inyeccion de dependencias

    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var texto = "Estamos en semana 4";
        model.addAttribute("saludo", texto);

        var categorias = categoriaService.getCategorias(false); //hace select de la tabla y devuelve un arraylist

        model.addAttribute("categorias", categorias);

        return "/categoria/listado";
    }

    //mapeo de los recursos
    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado"; //para redireccionar la ruta
    }

    @GetMapping("/categoria/actualiza/{idCategoria}")
    public String categoriaActualiza(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria); // va y hace un select en la tabla
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }

    @GetMapping("/categoria/elimina/{idCategoria}")
    public String categoriaElimina(Categoria categoria) {
        categoriaService.delete(categoria); // va y hace un select en la tabla
        return "redirect:/categoria/listado";
    }
}

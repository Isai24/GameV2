package com.example.GameStore.controller;

import com.example.GameStore.model.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }

    /* métod para solo ver una página de inicio de sesión
    @GetMapping("/")
    public String verPaginaDeInicio() {
        return "index";
    }*/

}

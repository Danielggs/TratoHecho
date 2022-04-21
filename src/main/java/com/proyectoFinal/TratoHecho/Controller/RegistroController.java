/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoFinal.TratoHecho.Controller;

import com.proyectoFinal.TratoHecho.Entidades.Usuario;
import com.proyectoFinal.TratoHecho.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    public UsuarioServicio usuarioServicio;

    @GetMapping("")
    public String registro() {
        return "usuario-Formulario";

    }

    @PostMapping("/save")
    public String registroUsuario(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("rol") String rol,
            Model modelo) {
        try {
            Usuario usuario = usuarioServicio.registrarUsuario(username, password, password2,rol);
            return "index";
        } catch (Exception ex) {
            ex.printStackTrace();
            modelo.addAttribute("username", username);
            modelo.addAttribute("password", password);
            modelo.addAttribute("password2", password2);
            modelo.addAttribute("error", ex.getMessage());
            return "usuario-Formulario";
        }
    }

}

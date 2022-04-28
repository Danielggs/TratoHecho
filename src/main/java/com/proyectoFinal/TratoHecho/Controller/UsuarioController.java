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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    
    
    @Autowired
    private UsuarioServicio usuarioService;
    @GetMapping("/form")
    public String form(){
         return "usuario-form" ;
    }
    
    
    //
    @PostMapping("/save")
    public String save(@RequestParam("correo") String contenido){
        Usuario usuario = new Usuario();
        usuario.setUsername(contenido);
        
        //guardamos el usuario en el service de l
      usuarioService.guardarUsuario(usuario);
        return "usuario-form";
    }
  
  
           
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoFinal.TratoHecho.Controller;

import com.proyectoFinal.TratoHecho.Repositori.UsuarioRepositorio;
import com.proyectoFinal.TratoHecho.Servicios.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @GetMapping("/perfil")
    public String perfil(){
       
        
        return "Perfil";
    }
    

}

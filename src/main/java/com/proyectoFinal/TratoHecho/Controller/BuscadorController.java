/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoFinal.TratoHecho.Controller;

import com.proyectoFinal.TratoHecho.Entidades.Usuario;
import com.proyectoFinal.TratoHecho.Servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trabajadores")
public class BuscadorController {
     @Autowired
     private UsuarioServicio usuarioservicio;
     
     
    @GetMapping("")
    public String listTrabajadores(Model modelo){
    List<Usuario> usuario = usuarioservicio.ListarTrabajadores();
    modelo.addAttribute("listaDetrabajadores", usuario);
    return "Listar_Trabajadores";
    }
            
  
}

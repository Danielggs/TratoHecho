/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoFinal.TratoHecho.Controller;

import com.proyectoFinal.TratoHecho.Entidades.Usuario;
import com.proyectoFinal.TratoHecho.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/foto")

public class FotoController {
 @Autowired UsuarioServicio usuarioServicio;
    
 @GetMapping("/usuario")
 public ResponseEntity<byte[]> mostrarFotoPerfil(@RequestParam("idUsuario")String id){
     try {
         Usuario usuario= usuarioServicio.buscarUId(id);
     byte[] foto = usuario.getFoto().getContenido();
     HttpHeaders header = new HttpHeaders();
     header.setContentType(MediaType.IMAGE_JPEG);
     return new ResponseEntity<>(foto,header,HttpStatus.OK);

     } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
      
        
 }

}
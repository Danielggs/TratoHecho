/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoFinal.TratoHecho.Servicios;

import com.proyectoFinal.TratoHecho.Entidades.Contratacion;
import com.proyectoFinal.TratoHecho.Repositori.ContratacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratacionServicio {
    
    @Autowired
    private ContratacionRepositorio contratacionRepositorio;
    
    public Contratacion guardarContratacion(Contratacion contratacion){
    
    return contratacionRepositorio.save(contratacion);
    }
            

}

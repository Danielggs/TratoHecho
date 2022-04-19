/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoFinal.TratoHecho.Repositori;

import com.proyectoFinal.TratoHecho.Entidades.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel
 */
@Repository
public interface ContratacionRepositorio extends JpaRepository<Contratacion, String>{
    
}

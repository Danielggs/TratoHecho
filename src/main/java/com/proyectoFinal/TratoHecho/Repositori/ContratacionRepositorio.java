package com.proyectoFinal.TratoHecho.Repositori;

import com.proyectoFinal.TratoHecho.Entidades.Contratacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratacionRepositorio extends JpaRepository<Contratacion, String>{
    
    @Query("Select c from Contratacion c where c.cliente.id = :clienteid")
    public List<Contratacion> listarContratacionesPorCliente(@Param("clienteid") String clienteid);
    
    @Query("Select c from Contratacion c where c.cliente.id = :clienteid and c.trabajador.id =:trabajadorid")
    public Contratacion buscarContratacion(@Param("clienteid") String clienteid, @Param("trabajadorid") String trabajadorid);

    
}

package com.proyectoFinal.TratoHecho.Servicios;

import com.proyectoFinal.TratoHecho.Entidades.Contratacion;
import com.proyectoFinal.TratoHecho.Entidades.Enum.Estado;
import com.proyectoFinal.TratoHecho.Entidades.Usuario;
import com.proyectoFinal.TratoHecho.Repositori.ContratacionRepositorio;
import com.proyectoFinal.TratoHecho.Repositori.UsuarioRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratacionServicio {

    @Autowired
    private ContratacionRepositorio contratacionRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void contratar(String idUsuarioCliente, String idUsuarioTrabajador, String descripcion) throws Exception {
        Contratacion contratacion = new Contratacion();
        contratacion.setFechaContratacion(new Date());
        contratacion.setDescripcion(descripcion);
        contratacion.setEstado(Estado.ESPERANDO_CONFIRMACION);

        if (idUsuarioCliente.equals(idUsuarioTrabajador)) {
            System.out.println("Esta intentando contratarse a si mismo");
            throw new Exception("No puede contratarse a usted mismo");
        }

        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuarioCliente);
        if (respuesta.isPresent()) {
            Usuario usuarioCliente = respuesta.get();
            contratacion.setCliente(usuarioCliente);
        } else {
            System.out.println("No se encontro el usuario cliente");
            throw new Exception("No existe su usuario");
        }

        Optional<Usuario> respuesta2 = usuarioRepositorio.findById(idUsuarioTrabajador);
        if (respuesta2.isPresent()) {
            Usuario usuarioTrabajador = respuesta2.get();
            contratacion.setTrabajador(usuarioTrabajador);
        } else {
            System.out.println("No se encontro el usuario trabajador");
            System.out.println("No se encontro el usuario trabajador");
            System.out.println("No se encontro el usuario trabajador");
            throw new Exception("No existe el trabajador que quiere contratar");
        }
          List<Contratacion> find = findAll();
           Optional<Usuario> respuesta3 = usuarioRepositorio.findById(idUsuarioTrabajador);
        Integer cont=0;
        for (Contratacion contratacion1 : find) {
            System.out.println("SE SUMARON DENTRO DEL FIND " +cont );
            System.out.println("CONTRATACION"+contratacion1.getTrabajador().toString());
            System.out.println("AAA"+ respuesta3.toString());
            if (contratacion1.getTrabajador().getId().equalsIgnoreCase(idUsuarioTrabajador)){
                cont++;
                System.out.println("SE SUMARON " +cont );
            }
            
        }
        if (cont<1) {
            Usuario usuarioTrabajador = respuesta3.get();
            contratacion.setTrabajador(usuarioTrabajador);
            System.out.println("SE SUMARON " +cont );
        } else {
            System.out.println("No puedes contratar mas de una ves al mismo tiempo al trabajador");

            throw new Exception("No puedes contratar mas de una ves al mismo tiempo al trabajador");
        }    
      

        contratacionRepositorio.save(contratacion);
    }

    @Transactional
    public void responder(String idContratacion, Estado estado) throws Exception {
        Optional<Contratacion> respuesta = contratacionRepositorio.findById(idContratacion);
        if (respuesta.isPresent()) {
            Contratacion contratacion = respuesta.get();
            if (contratacion.getEstado() == Estado.ESPERANDO_CONFIRMACION) {
                contratacion.setEstado(estado);
                contratacionRepositorio.save(contratacion);
            } else {
                throw new Exception("La contratacion ya fue respondida");
            }
        } else {
            throw new Exception("No existe la contratacion");
        }
    }

    public List<Contratacion> buscarContratacionId(String idCliente) {
        return contratacionRepositorio.listarContratacionesPorCliente(idCliente);
    }
    public List<Contratacion> findAll(){
        return contratacionRepositorio.findAll();
    }

   @Transactional
    public void eliminarContratacion(String idCliente, String idTrabajador) throws Exception {
        Contratacion respuesta = contratacionRepositorio.buscarContratacion(idCliente, idTrabajador);
        if (respuesta == null) {
            throw new Exception("No se encontro la contratacion a eliminar");
        } else {
            contratacionRepositorio.delete(respuesta);
        }
    }


//    @Transactional
//    public void modificar(String idContratacion, Estado estado){
//        
//    }
}

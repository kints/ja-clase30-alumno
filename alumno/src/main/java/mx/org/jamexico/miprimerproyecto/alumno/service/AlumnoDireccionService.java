package mx.org.jamexico.miprimerproyecto.alumno.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
import mx.org.jamexico.miprimerproyecto.alumno.model.Direccion;
import mx.org.jamexico.miprimerproyecto.alumno.repository.AlumnoRepository;
import mx.org.jamexico.miprimerproyecto.alumno.repository.DireccionRepository;
import mx.org.jamexico.miprimerproyecto.alumno.resource.AlumnoDireccionResource;

@Service
public class AlumnoDireccionService {

  @Autowired
  private DireccionRepository direccionRepository;
  @Autowired
  private AlumnoService alumnoService;

  public AlumnoDireccionResource altaAlumnoDireccion(UUID idAlumno,
      Direccion direccionReq) {
    Alumno alumnoParaActualizar = alumnoService.findById(idAlumno);
    direccionReq.setAlumno(alumnoParaActualizar);
    Direccion direccionNueva = direccionRepository.save(direccionReq);
    AlumnoDireccionResource response = new AlumnoDireccionResource();
    response.setNombre(alumnoParaActualizar.getNombre());
    response.setApellidoPaterno(alumnoParaActualizar.getApellidoPaterno());
    response.setApellidoMaterno(alumnoParaActualizar.getApellidoMaterno());
    response.setCalle(direccionNueva.getCalle());
    response.setNumeroExterior(direccionNueva.getNumeroExterior());
    response.setNumeroInterior(direccionNueva.getNumeroInterior());
    response.setCodigoPostal(direccionNueva.getCodigoPostal());
    response.setColonia(direccionNueva.getColonia());
    response.setEstado(direccionNueva.getEstado());
    response.setCalle(direccionNueva.getCalle());
    response.setPais(direccionNueva.getPais());

    return response;
  }

  public AlumnoDireccionResource encuentraAlumnoDireccion(UUID idAlumno) {
    Alumno alumno = alumnoService.findById(idAlumno);
    List<Direccion> direccionLista = direccionRepository.findByAlumno(alumno);
    if (direccionLista.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la direccion");
    }
    Direccion direccionAlumno = direccionLista.get(0);
    AlumnoDireccionResource response = new AlumnoDireccionResource();
    response.setNombre(alumno.getNombre());
    response.setApellidoPaterno(alumno.getApellidoPaterno());
    response.setApellidoMaterno(alumno.getApellidoMaterno());
    response.setCalle(direccionAlumno.getCalle());
    response.setNumeroExterior(direccionAlumno.getNumeroExterior());
    response.setNumeroInterior(direccionAlumno.getNumeroInterior());
    response.setCodigoPostal(direccionAlumno.getCodigoPostal());
    response.setColonia(direccionAlumno.getColonia());
    response.setEstado(direccionAlumno.getEstado());
    response.setCalle(direccionAlumno.getCalle());
    response.setPais(direccionAlumno.getPais());
    return response;
  }

}

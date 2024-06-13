package mx.org.jamexico.miprimerproyecto.alumno.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
import mx.org.jamexico.miprimerproyecto.alumno.model.Direccion;
import mx.org.jamexico.miprimerproyecto.alumno.repository.AlumnoRepository;

@Service
public class AlumnoService {
  @Autowired
  private AlumnoRepository alumnoRepository;

  // Create
  public Alumno save(Alumno alumno) {
    alumno.setActivo(true);
    alumno.setFechaBaja(null);
    return alumnoRepository.save(alumno);
  }

  // Read
  public Alumno findById(UUID idReq) {
    Optional<Alumno> alumOptional = alumnoRepository.findById(idReq);
    if (!alumOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontré el registro");
    }
    return alumOptional.get();
  }

  // Update
  public Alumno actualiza(UUID idReq, Alumno alumnoReq) {

    Alumno alumnoParaActualizar = findById(idReq);
    alumnoParaActualizar.setNombre(alumnoReq.getNombre());
    alumnoParaActualizar.setApellidoPaterno(alumnoReq.getApellidoPaterno());
    alumnoParaActualizar.setApellidoMaterno(alumnoReq.getApellidoMaterno());
    alumnoParaActualizar.setCurp(alumnoReq.getCurp());
    alumnoParaActualizar.setGenero(alumnoReq.getGenero());
    alumnoParaActualizar.setTipoSangre(alumnoReq.getTipoSangre());
    alumnoParaActualizar.setFechaNacimiento(alumnoReq.getFechaNacimiento());
    return alumnoRepository.save(alumnoParaActualizar);
  }

  public Alumno actualizaDireccion(Alumno alumnoReq, Direccion direccion) {
    alumnoReq.setDireccion(direccion);
    return alumnoRepository.save(alumnoReq);
  }

  public void borrarAlumno(UUID idReq) {
    Alumno alumnoParBorrar = findById(idReq);
    alumnoRepository.delete(alumnoParBorrar);
  }
}

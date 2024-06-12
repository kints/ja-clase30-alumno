package mx.org.jamexico.miprimerproyecto.alumno.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
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
  public Optional<Alumno> findById(UUID id) {
    return alumnoRepository.findById(id);
  }

  // Update
  public Alumno actualiza(UUID idReq, Alumno alumnoReq) {
    Optional<Alumno> alumOptional = alumnoRepository.findById(idReq);
    if (!alumOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontré el registro");
    }
    Alumno alumnoParaActualizar = alumOptional.get();
    alumnoParaActualizar.setNombre(alumnoReq.getNombre());
    alumnoParaActualizar.setApellidoPaterno(alumnoReq.getApellidoPaterno());
    alumnoParaActualizar.setApellidoMaterno(alumnoReq.getApellidoMaterno());
    alumnoParaActualizar.setCurp(alumnoReq.getCurp());
    alumnoParaActualizar.setGenero(alumnoReq.getGenero());
    alumnoParaActualizar.setTipoSangre(alumnoReq.getTipoSangre());
    alumnoParaActualizar.setFechaNacimiento(alumnoReq.getFechaNacimiento());
    Alumno alumnoActualizado = alumnoRepository.save(alumnoParaActualizar);
    return alumnoActualizado;
  }

  public void borrarAlumno(UUID idReq) {
    Optional<Alumno> alumOptional = alumnoRepository.findById(idReq);
    if (!alumOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontré el registro, no lo puedo borrar");
    }
    Alumno alumnoParBorrar = alumOptional.get();
    alumnoRepository.delete(alumnoParBorrar);
  }
}

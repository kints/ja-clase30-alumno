package mx.org.jamexico.miprimerproyecto.alumno.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
import mx.org.jamexico.miprimerproyecto.alumno.repository.AlumnoRepository;

@Service
public class AlumnoService {
  @Autowired
  private AlumnoRepository alumnoRepository;

  // Create
  public Alumno save(Alumno alumno) {
    return alumnoRepository.save(alumno);
  }

  // Read
  public Optional<Alumno> findById(UUID id) {
    return alumnoRepository.findById(id);
  }
}

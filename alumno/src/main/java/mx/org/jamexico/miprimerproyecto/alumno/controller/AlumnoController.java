package mx.org.jamexico.miprimerproyecto.alumno.controller;

import org.springframework.web.bind.annotation.RestController;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
import mx.org.jamexico.miprimerproyecto.alumno.service.AlumnoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/alumnos/v1")
public class AlumnoController {
  @Autowired
  AlumnoService alumnoService;

  @GetMapping("/")
  public ResponseEntity<Alumno> getAlumn() {
    Alumno alumnoEjemplo = new Alumno(UUID.randomUUID(), "Neira", 26);
    return ResponseEntity.ok(alumnoEjemplo);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Alumno> getMethodName(@PathVariable UUID id) {
    Optional<Alumno> optAlumno = alumnoService.findById(id);
    if (!optAlumno.isPresent()) {
      ResponseEntity.noContent();
    }
    return ResponseEntity.ok(optAlumno.get());
  }

  @PostMapping("/")
  public ResponseEntity<Alumno> alta(@RequestBody Alumno reqAlumno) {

    Alumno savedAlumno = alumnoService.save(reqAlumno);

    return ResponseEntity.ok(savedAlumno);
  }

}

package mx.org.jamexico.miprimerproyecto.alumno.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.org.jamexico.miprimerproyecto.alumno.resource.AlumnoDireccionResource;
import mx.org.jamexico.miprimerproyecto.alumno.service.AlumnoDireccionService;
import mx.org.jamexico.miprimerproyecto.alumno.model.Direccion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/alumnoDireccion/")
public class AlumnoDireccion {
  @Autowired
  private AlumnoDireccionService AlumnoDireccionService;

  @PostMapping("alta/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> altaDireccionAlumno(@PathVariable UUID idAlumno,
      @RequestBody Direccion direccion) {
    return ResponseEntity.ok(AlumnoDireccionService.altaAlumnoDireccion(idAlumno, direccion));
  }

  @GetMapping("encuentra/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> encuentraDireccionAlumno(@PathVariable UUID idAlumno) {
    return ResponseEntity.ok(AlumnoDireccionService.encuentraAlumnoDireccion(idAlumno));
  }

}

package mx.org.jamexico.miprimerproyecto.alumno.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.org.jamexico.miprimerproyecto.alumno.model.Alumno;
import mx.org.jamexico.miprimerproyecto.alumno.model.Direccion;
import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, UUID> {
  public List<Direccion> findByAlumno(Alumno alumno);
}

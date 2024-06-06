package mx.org.jamexico.miprimerproyecto.alumno.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
  @Id
  @GeneratedValue
  private UUID id;

  private String nombre;
  private int edad;
}

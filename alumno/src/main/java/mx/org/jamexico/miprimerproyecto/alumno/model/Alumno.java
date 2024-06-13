package mx.org.jamexico.miprimerproyecto.alumno.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
  private String apellidoPaterno;
  private String apellidoMaterno;
  @Enumerated(EnumType.ORDINAL)
  private Genero genero;
  @Enumerated(EnumType.STRING)
  private TipoSangre tipoSangre;
  private String curp;
  private LocalDate fechaNacimiento;
  private boolean activo;
  private LocalDate fechaBaja;
  @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL)
  private Direccion direccion;
}

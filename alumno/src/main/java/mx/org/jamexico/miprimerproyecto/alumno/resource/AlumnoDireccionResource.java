package mx.org.jamexico.miprimerproyecto.alumno.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDireccionResource {
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String calle;
  private String numeroExterior;
  private String numeroInterior;
  private String colonia;
  private String municipio;
  private String estado;
  private String pais;
  private String codigoPostal;
}

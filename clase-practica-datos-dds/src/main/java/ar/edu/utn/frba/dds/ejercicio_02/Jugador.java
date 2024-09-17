package ar.edu.utn.frba.dds.ejercicio_02;

import ar.edu.utn.frba.dds.ejercicio_02.converters.localDateConverter;
import ar.edu.utn.frba.dds.ejercicio_02.personajes.Personaje;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name= "nombre")
  private String nombre;
  @Column(name= "apellido")
  private String apellido;
  @Convert(converter = localDateConverter.class)
  private LocalDate fechaAlta;
  @OneToOne
  @JoinColumn(name = "personaje_id")
  private Personaje personaje;

  public Jugador() {
    this.fechaAlta = LocalDate.now();
  }

  public void cambiarPersonaje(Personaje personaje) {
    this.personaje = personaje;
  }
}

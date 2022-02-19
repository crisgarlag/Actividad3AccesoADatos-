package modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trofeos")
public class Trofeo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "fk_id_ganador", referencedColumnName = "id")
	private Jugador jugador;
	@OneToOne
	@JoinColumn(name = "fk_id_torneo", referencedColumnName = "id")
	private Torneo torneo;
	
	public Trofeo(Integer id, String nombre, Jugador jugador, Torneo torneo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jugador = jugador;
		this.torneo = torneo;
	}
	
	public Trofeo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	@Override
	public String toString() {
		return "Trofeo [id=" + id + ", nombre=" + nombre + ", jugador=" + jugador + ", torneo=" + torneo + "]";
	}
	
	

}

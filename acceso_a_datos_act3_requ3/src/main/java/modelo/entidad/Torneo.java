package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="torneos")
public class Torneo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String deporte;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@ManyToMany(mappedBy = "torneos",cascade = CascadeType.PERSIST)
	private List<Jugador> jugadores;
	@OneToOne(mappedBy = "torneo", cascade = CascadeType.ALL)
	private Trofeo trofeo;
	
	public Torneo(Integer id, String nombre, String deporte, Date fecha, List<Jugador> jugadores, Trofeo trofeo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.deporte = deporte;
		this.fecha = fecha;
		this.jugadores = jugadores;
		this.trofeo = trofeo;
	}

	public Torneo() {
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Trofeo getTrofeo() {
		return trofeo;
	}

	public void setTrofeo(Trofeo trofeo) {
		this.trofeo = trofeo;
	}

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", deporte=" + deporte + ", fecha=" + fecha + ", jugadores="
				+ jugadores + ", trofeo=" + trofeo + "]";
	}
	
}

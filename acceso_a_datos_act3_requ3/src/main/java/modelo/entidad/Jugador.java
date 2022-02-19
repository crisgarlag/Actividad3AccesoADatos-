package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "jugadores")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private int ranking;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "jugadores_torneos",
				joinColumns = {@JoinColumn(name="fk_id_jugador", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="fk_id_torneo", referencedColumnName = "id")})
	private List<Torneo> torneos;
	@OneToMany(mappedBy = "jugador", cascade = CascadeType.PERSIST)
	private List<Trofeo> trofeos;
	
	
	public Jugador(Integer id, String nombre, int ranking, List<Torneo> torneos, List<Trofeo> trofeos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.torneos = torneos;
		this.trofeos = trofeos;
	}


	public Jugador() {
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


	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public List<Torneo> getTorneos() {
		return torneos;
	}


	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}


	public List<Trofeo> getTrofeos() {
		return trofeos;
	}


	public void setTrofeos(List<Trofeo> trofeos) {
		this.trofeos = trofeos;
	}


	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", ranking=" + ranking + ", torneos=" + torneos
				+ ", trofeos=" + trofeos + "]";
	}
	
	
	
	
	
}

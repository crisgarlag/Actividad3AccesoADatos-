package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String propietario;
	@Embedded
	private Direccion direccion;
	// En este caso no creo una entidad intermedia porque la tabla interemedia que se va a 
	// crear solo necesito que tenga un id y las fk
	@ManyToMany(mappedBy = "libreria", cascade = CascadeType.PERSIST)
	private List<Libro>libros;
	
	public Libreria(Integer id, String nombre, String propietario, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.propietario = propietario;
		this.direccion = direccion;
	}

	public Libreria() {
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

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}
	
}

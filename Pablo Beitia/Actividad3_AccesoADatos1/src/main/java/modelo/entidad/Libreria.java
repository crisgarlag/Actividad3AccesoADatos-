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
@Table(name = "librerias")
public class Libreria {
	/**
	 * Librería, tendrá un id, un nombre, un nombre del dueño, una dirección y una colección de libros. 
	 * Además, hay que tener en cuenta que un libro puede estar en diferentes librerías.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nombre_dueño;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToMany(mappedBy = "libreria", cascade=CascadeType.PERSIST)
	private List<Libro> libros;

	public Libreria() {
		super();
	}

	public Libreria(Integer id, String nombre, String nombre_dueño, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombre_dueño = nombre_dueño;
		this.direccion = direccion;
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

	public String getNombre_dueño() {
		return nombre_dueño;
	}

	public void setNombre_dueño(String nombre_dueño) {
		this.nombre_dueño = nombre_dueño;
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
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombre_dueño=" + nombre_dueño + ", direccion="
				+ direccion + ", libros=" + libros + "]";
	}
	
}

package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="editoriales")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Embedded
	private Direccion direccion;
	// El mapeo se realiza contra el atributo de la clase Libro que llevara la fk, 
	// en ese caso se llama editorial
	//Se utiliza cascade en caso de persistencia no en todos los casos pues al 
	//borrar una editorial podria borrar un libro
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.PERSIST)
	private List<Libro>libros;
	
	
	public Editorial(Integer id, String nombre, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		}


	public Editorial() {
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
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", libros=" + libros + "]";
	}
	
	

}

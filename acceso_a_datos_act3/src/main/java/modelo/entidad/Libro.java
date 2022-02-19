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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private double precio;
	@ManyToOne
	@JoinColumn(name="fk_id_editorial", referencedColumnName = "id")
	private Editorial editorial;
	@ManyToOne
	@JoinColumn(name="fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	
	//Al ser una relacion N:N se le indica que dos pk pasan a ser fk de la nueva tabla generada.
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="libreria_libros",
				joinColumns = {@JoinColumn(name="fk_id_libro", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="fk_id_libreria", referencedColumnName = "id")})
	private List<Libreria> libreria;
	
	public Libro(Integer id, String titulo, double precio, Editorial editorial, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
	}

	public Libro() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	public List<Libreria> getLibreria() {
		return libreria;
	}

	public void setLibreria(List<Libreria> libreria) {
		this.libreria = libreria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + "]";
	}
	
	

}

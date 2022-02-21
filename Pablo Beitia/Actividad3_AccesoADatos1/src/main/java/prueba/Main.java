package prueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;


public class Main {
	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("JPA-Libreria");
		rellenarBD();
	}
	
	public static void rellenarBD() {
		
		Direccion direccionEditorialAnaya = new Direccion("Calle", "Juan Ignacio Luca de Tena 15", "Madrid");
		Direccion direccionEditorialEdelvives = new Direccion("Calle", "Xaudaró 25", "Madrid");
		Direccion direccionCasaDelLibro = new Direccion("Calle", "Gran Vía 29", "Madrid");
		Direccion direccionLibreriaDelMercado = new Direccion("Calle", "de Tribulete 18", "Madrid");
		
		Editorial editorialAnaya = new Editorial(null, "Editorial Anaya", direccionEditorialAnaya);
		Editorial editorialEdelvives = new Editorial(null, "Editorial Edelvives", direccionEditorialEdelvives);
		
		Autor julioVerne = new Autor(null, "Julio", "Verne", new Date());
		Autor lopeDeVega = new Autor(null, "Lope", "De Vega", new Date());
		Autor lewisCarrol = new Autor(null, "Lewis", "Carrol", new Date());
		
		Libro viajeAlCentroDeLaTierra = new Libro(null, "Viaje Al Centro De La Tierra", 35, julioVerne, editorialAnaya);
		Libro leguasViajeSubmarino = new Libro(null, "Veinte Mil Leguas De Viaje Submarino", 30, julioVerne, editorialAnaya);
		Libro fuenteOvejuna = new Libro(null, "Fuente Ovejuna", 11.95, lopeDeVega, editorialEdelvives);
		Libro elCaballeroDeOlmedo = new Libro(null, "El Caballero De Olmedo", 10.95, lopeDeVega, editorialAnaya);
		Libro elPerroDelHortelano = new Libro(null, "El Perro Del Hortelano", 20.67, lopeDeVega, editorialEdelvives);
		Libro laCazaDelSnark = new Libro(null, "La Caza Del Snark", 20.10, lewisCarrol, editorialAnaya);
		Libro aliciaMaravillas = new Libro(null, "Alicia en el País de las Maravillas", 19.95, lewisCarrol, editorialEdelvives);
		Libro silviaYBruno = new Libro(null, "Silvia y Bruno", 15.99, lewisCarrol, editorialEdelvives);
		
		Libreria casaDelLibro = new Libreria(null,"Casa Del Libro", "Espasa-Calpe",direccionCasaDelLibro); 
		Libreria libreriaDelMercado = new Libreria(null,"Libreria Del Mercado", "Laura Martínez",direccionLibreriaDelMercado); 
		
		List<Libro> librosJulioVerne = new ArrayList<Libro>();
		librosJulioVerne.add(viajeAlCentroDeLaTierra);
		librosJulioVerne.add(leguasViajeSubmarino);
		julioVerne.setLibros(librosJulioVerne);
		
		List<Libro> librosLopeVega = new ArrayList<Libro>();
		librosLopeVega.add(fuenteOvejuna);
		librosLopeVega.add(elCaballeroDeOlmedo);
		librosLopeVega.add(elPerroDelHortelano);
		lopeDeVega.setLibros(librosLopeVega);
		
		List<Libro> librosLewisCarrol = new ArrayList<Libro>();
		librosLewisCarrol.add(silviaYBruno);
		librosLewisCarrol.add(laCazaDelSnark);
		librosLewisCarrol.add(aliciaMaravillas);
		lewisCarrol.setLibros(librosLewisCarrol);
		
		//Añadir Libros a Editoriales
		List<Libro> librosAnaya = new ArrayList<Libro>();
		librosAnaya.add(viajeAlCentroDeLaTierra);
		librosAnaya.add(leguasViajeSubmarino);
		librosAnaya.add(elCaballeroDeOlmedo);
		librosAnaya.add(laCazaDelSnark);
		editorialAnaya.setLibros(librosAnaya);
		
		List<Libro> librosEdelvives = new ArrayList<Libro>();
		librosEdelvives.add(elPerroDelHortelano);
		librosEdelvives.add(fuenteOvejuna);
		librosEdelvives.add(silviaYBruno);
		librosEdelvives.add(aliciaMaravillas);
		editorialEdelvives.setLibros(librosEdelvives);
		
		//Añadir Libros a Librerias
		List<Libreria> libreriaPerroHortelano = new ArrayList<Libreria>();
		libreriaPerroHortelano.add(casaDelLibro);
		elPerroDelHortelano.setLibreria(libreriaPerroHortelano);
		
		List<Libreria> libreriaCazaSnark = new ArrayList<Libreria>();
		libreriaCazaSnark.add(casaDelLibro);
		laCazaDelSnark.setLibreria(libreriaCazaSnark);
		
		List<Libreria> libreriaCabOlm = new ArrayList<Libreria>();
		libreriaCabOlm.add(casaDelLibro);
		elCaballeroDeOlmedo.setLibreria(libreriaCabOlm);
		
		List<Libreria> libreriaLeguas = new ArrayList<Libreria>();
		libreriaLeguas.add(casaDelLibro);
		libreriaLeguas.add(libreriaDelMercado);
		leguasViajeSubmarino.setLibreria(libreriaLeguas);
		
		List<Libreria> libreriaviajCen = new ArrayList<Libreria>();
		libreriaviajCen.add(libreriaDelMercado);
		viajeAlCentroDeLaTierra.setLibreria(libreriaviajCen);
		
		List<Libreria> libreriaSilviaBruno = new ArrayList<Libreria>();
		libreriaSilviaBruno.add(libreriaDelMercado);
		silviaYBruno.setLibreria(libreriaSilviaBruno);
		
		List<Libreria> libreriaAliciaMaravillas = new ArrayList<Libreria>();
		libreriaAliciaMaravillas.add(libreriaDelMercado);
		aliciaMaravillas.setLibreria(libreriaAliciaMaravillas);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(lopeDeVega);
		em.persist(lewisCarrol);
		em.persist(julioVerne);
		em.persist(editorialAnaya);
		em.persist(editorialEdelvives);
		em.getTransaction().commit();
		em.close();
	}
}

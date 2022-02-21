package modelo.vista;

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

		emf = Persistence.createEntityManagerFactory("JPALibreria");

		iniciar();

		em = emf.createEntityManager();
		
		
		System.out.println("\n*****Libros con su editorial y autor*****\n");
		Query queryLibros = em.createQuery(
				"Select l.titulo, e.nombre, a.nombre, a.apellidos from Libro l inner join l.editorial e inner join l.autor a");
		List<Object[]> lista = queryLibros.getResultList();
		for (Object[] l : lista) {
			System.out.println("Libro: " + l[0] + ". Editorial: " + l[1] + ". Autor: " + l[2] + " " + l[3]);
		}

		System.out.println("\n*****Autores con sus libros*****\n");
		Query queryAutores = em.createQuery("Select a.nombre, a.apellidos, l.titulo from Autor a inner join a.libros l");
		lista = queryAutores.getResultList();
		for (Object[] a : lista) {
			System.out.println("Autor: " + a[0]+ " " + a[1] + ". Libro: " + a[2]);
		}

		System.out.println("\n*****Libros y su libreria*****\n");
		Query queryLibros2 = em
				.createQuery("Select l.titulo, libre.nombre from Libreria libre right join libre.libros l");
		lista = queryLibros2.getResultList();
		for (Object[] l : lista) {
			System.out.println("Libro: " + l[0] + ". Libreria: " + l[1]);
		}
		
		System.out.println("\n*****Librerias con sus libros*****\n");
		Query queryLibrerias = em
				.createQuery("Select libre.nombre, l.titulo from Libreria libre inner join libre.libros l");
		lista = queryLibrerias.getResultList();
		for (Object[] l : lista) {
			System.out.println("Autor: " + l[0] + ". Libro: " + l[1]);
		}
		
		em.close();

	}
	
	private static void iniciar() {
		
		
		Direccion direccionPlaneta = new Direccion("Calle", "El pilar", "Madrid");
		Direccion direccionArpa = new Direccion("Avenida", "Arpa", "Madrid");
		Direccion direccionCervantes = new Direccion("Plaza", "Colon", "Madrid");
		Direccion direccionFiccion = new Direccion("Calle", "San Miguel", "Madrid");
		Autor tolkien = new Autor(null, "J.R.R.", "Tolkien", new Date());
		Autor aramburu = new Autor(null, "Fernando", "Aramburu", new Date());
		Autor follett = new Autor(null, "Ken", "Follet", new Date());
		Editorial edPlaneta = new Editorial(null, "Editorial Planeta", direccionPlaneta);
		Editorial edArpa = new Editorial(null, "Editorial Arpa", direccionArpa);
		Libro esdla1 = new Libro(null, "El señor de los anillos: La Comunidad del anillo", 20.0, edPlaneta, tolkien);
		Libro esdla2 = new Libro(null, "El señor de los anillos: Las dos torres", 21.0, edPlaneta, tolkien);
		Libro esdla3 = new Libro(null, "El señor de los anillos: El retorno del Rey", 22.0, edPlaneta, tolkien);
		Libro hobbit = new Libro(null, "El hobbit", 18.0, edArpa, tolkien);
		Libro patria = new Libro(null, "Patria", 18.0, edArpa, aramburu);
		Libro losVencejos = new Libro(null, "Los Vencejos", 18.0, edPlaneta, aramburu);
		Libro pilares = new Libro(null, "Los Pilares de la tierra", 30.0, edArpa, follett);
		Libro libertad = new Libro(null, "Un lugar llamado libertad", 18.0, edPlaneta, follett);
		Libreria libCervantes = new Libreria(null, "Libreria Cervantes", "Jose Luis Rodriguez", direccionFiccion);
		Libreria libFiccion = new Libreria(null, "Libreria Ficcion", "Cristobal Soria", direccionFiccion);

	



		List<Libro> librosLibCervantes = new ArrayList<Libro>();
		librosLibCervantes.add(esdla1);
		librosLibCervantes.add(esdla2);
		librosLibCervantes.add(esdla3);
		librosLibCervantes.add(hobbit);
		libCervantes.setLibros(librosLibCervantes);

		
		List<Libro> librosLibFiccion = new ArrayList<Libro>();
		librosLibFiccion.add(esdla1);
		librosLibFiccion.add(esdla2);
		librosLibFiccion.add(esdla3);
		librosLibFiccion.add(hobbit);
		libFiccion.setLibros(librosLibFiccion);

		
		List<Libreria> libreriaEsdla1 = new ArrayList<Libreria>();
		libreriaEsdla1.add(libCervantes);
		libreriaEsdla1.add(libFiccion);
		esdla1.setLibreria(libreriaEsdla1);

	
		List<Libreria> libreriaEsdla2 = new ArrayList<Libreria>();
		libreriaEsdla2.add(libCervantes);
		libreriaEsdla2.add(libFiccion);
		esdla2.setLibreria(libreriaEsdla2);

		
		List<Libreria> libreriaEsdla3 = new ArrayList<Libreria>();
		libreriaEsdla3.add(libCervantes);
		libreriaEsdla3.add(libFiccion);
		esdla3.setLibreria(libreriaEsdla3);

		
		List<Libreria> libreriaHobbit = new ArrayList<Libreria>();
		libreriaHobbit.add(libCervantes);
		libreriaHobbit.add(libFiccion);
		hobbit.setLibreria(libreriaHobbit);

		
		List<Libro> librosTolkien = new ArrayList<Libro>();
		librosTolkien.add(esdla1);
		librosTolkien.add(esdla2);
		librosTolkien.add(esdla3);
		librosTolkien.add(hobbit);
		tolkien.setLibros(librosTolkien);

			List<Libro> librosEdPlaneta = new ArrayList<Libro>();
		librosEdPlaneta.add(esdla1);
		librosEdPlaneta.add(esdla2);
		librosEdPlaneta.add(esdla3);
		librosEdPlaneta.add(losVencejos);
		librosEdPlaneta.add(libertad);
		edPlaneta.setLibros(librosEdPlaneta);

		
		List<Libro> librosEdArpa = new ArrayList<Libro>();
		librosEdArpa.add(hobbit);
		librosEdArpa.add(patria);
		librosEdArpa.add(pilares);
		edArpa.setLibros(librosEdArpa);
		
		List<Libro> librosAramburu = new ArrayList<Libro>();
		librosAramburu.add(patria);
		librosAramburu.add(losVencejos);
		aramburu.setLibros(librosAramburu);

	
		List<Libro> librosFollet = new ArrayList<Libro>();
		librosFollet.add(pilares);
		librosFollet.add(libertad);
		follett.setLibros(librosFollet);

	
	
		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
	
		em.persist(tolkien);
		em.persist(aramburu);
		em.persist(follett);
		em.persist(edArpa);
		em.persist(edPlaneta);
		em.getTransaction().commit();
		em.close();
	}

}

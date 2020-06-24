package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredmet;
	
	private int espb;	
	
	private String nazivPredmeta;
	
	private int semestar;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="predmet")
	private List<Ispit> ispits;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	//bi-directional many-to-many association to Student
	@ManyToMany(mappedBy="predmets")
	private List<Student> students;

	public Predmet() {
	}

	public int getIdPredmet() {
		return this.idPredmet;
	}

	public void setIdPredmet(int idPredmet) {
		this.idPredmet = idPredmet;
	}

	public int getEspb() {
		return this.espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public String getNazivPredmeta() {
		return this.nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getSemestar() {
		return this.semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setPredmet(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setPredmet(null);

		return ispit;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
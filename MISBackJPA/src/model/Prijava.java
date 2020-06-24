package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the prijava database table.
 * 
 */
@Entity
@NamedQuery(name="Prijava.findAll", query="SELECT p FROM Prijava p")
public class Prijava implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijava;

	//bi-directional many-to-one association to Ispit
	@ManyToOne
	private Ispit ispit;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Prijava() {
	}

	public int getIdPrijava() {
		return this.idPrijava;
	}

	public void setIdPrijava(int idPrijava) {
		this.idPrijava = idPrijava;
	}

	public Ispit getIspit() {
		return this.ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
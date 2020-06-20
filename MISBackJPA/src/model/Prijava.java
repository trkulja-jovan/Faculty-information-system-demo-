package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


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
	@JsonProperty
	private int idPrijava;
	
	@JsonProperty
	private String ispitniRok;

	//bi-directional many-to-one association to Ispit
	@ManyToOne
	@JsonProperty
	private Ispit ispit;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JsonProperty
	private Student student;

	public Prijava() {
	}

	public int getIdPrijava() {
		return this.idPrijava;
	}

	public void setIdPrijava(int idPrijava) {
		this.idPrijava = idPrijava;
	}

	public String getIspitniRok() {
		return this.ispitniRok;
	}

	public void setIspitniRok(String ispitniRok) {
		this.ispitniRok = ispitniRok;
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
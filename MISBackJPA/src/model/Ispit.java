package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ispit database table.
 * 
 */
@Entity
@NamedQuery(name="Ispit.findAll", query="SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspit;

	private int ocena;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPolaganja;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	//bi-directional many-to-one association to Prijava
	@OneToMany(mappedBy="ispit")
	private List<Prijava> prijavas;

	public Ispit() {
	}

	public int getIdIspit() {
		return this.idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public double getBrBodova() {
		return this.ocena;
	}

	public Date getDatumPolaganja() {
		return this.datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Prijava> getPrijavas() {
		return this.prijavas;
	}

	public void setPrijavas(List<Prijava> prijavas) {
		this.prijavas = prijavas;
	}

	public Prijava addPrijava(Prijava prijava) {
		getPrijavas().add(prijava);
		prijava.setIspit(this);

		return prijava;
	}

	public Prijava removePrijava(Prijava prijava) {
		getPrijavas().remove(prijava);
		prijava.setIspit(null);

		return prijava;
	}

}
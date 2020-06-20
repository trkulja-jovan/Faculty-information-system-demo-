package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


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
	@JsonProperty
	private int idIspit;

	@Column(name="br_bodova")
	@JsonProperty
	private double brBodova;

	@Temporal(TemporalType.DATE)
	@JsonProperty
	private Date datum;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty
	private Date datumPolaganja;

	@Column(name="ukupno_bodova")
	@JsonProperty
	private double ukupnoBodova;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JsonProperty
	private Predmet predmet;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JsonProperty
	private Student student;

	//bi-directional many-to-one association to Prijava
	@OneToMany(mappedBy="ispit")
	@JsonProperty
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
		return this.brBodova;
	}

	public void setBrBodova(double brBodova) {
		this.brBodova = brBodova;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getDatumPolaganja() {
		return this.datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public double getUkupnoBodova() {
		return this.ukupnoBodova;
	}

	public void setUkupnoBodova(double ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
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
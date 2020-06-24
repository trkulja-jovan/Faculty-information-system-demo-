package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOsoba;
	
	private String brIndeksa;
	
	private int godinaStudija;
	
	private String ime;
	
	private String jmbg;
	
	private String prezime;

	//bi-directional many-to-one association to Prijava
	@OneToMany(mappedBy="student")
	private List<Prijava> prijavas;

	//bi-directional many-to-many association to Predmet
	@ManyToMany
	@JoinTable(
		name="slusa"
		, joinColumns={
			@JoinColumn(name="Student_idOsoba")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Predmet_idPredmet")
			}
		)
	private List<Predmet> predmets;

	//bi-directional many-to-many association to Ispit
	@OneToMany(mappedBy="student")
	private List<Ispit> ispits;

	public Student() {
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getBrIndeksa() {
		return this.brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public int getGodinaStudija() {
		return this.godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Prijava> getPrijavas() {
		return this.prijavas;
	}

	public void setPrijavas(List<Prijava> prijavas) {
		this.prijavas = prijavas;
	}

	public Prijava addPrijava(Prijava prijava) {
		getPrijavas().add(prijava);
		prijava.setStudent(this);

		return prijava;
	}

	public Prijava removePrijava(Prijava prijava) {
		getPrijavas().remove(prijava);
		prijava.setStudent(null);

		return prijava;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

}
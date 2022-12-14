package fr.inetum.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emprunt database table.
 * 
 */
@Entity
@NamedQuery(name="Emprunt.findAll", query="SELECT e FROM Emprunt e")
public class Emprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	//bi-directional many-to-one association to Abonne
	@ManyToOne
	@JoinColumn(name="idAbonne")
	private Abonne abonne;

	//bi-directional many-to-one association to Exemplaire
	@OneToMany(mappedBy="emprunt")
	private List<Exemplaire> exemplaires;

	public Emprunt() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public List<Exemplaire> getExemplaires() {
		return this.exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public Exemplaire addExemplaire(Exemplaire exemplaire) {
		getExemplaires().add(exemplaire);
		exemplaire.setEmprunt(this);

		return exemplaire;
	}

	public Exemplaire removeExemplaire(Exemplaire exemplaire) {
		getExemplaires().remove(exemplaire);
		exemplaire.setEmprunt(null);

		return exemplaire;
	}

}
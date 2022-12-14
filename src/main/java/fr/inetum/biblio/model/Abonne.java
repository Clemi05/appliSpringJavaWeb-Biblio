package fr.inetum.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the abonne database table.
 * 
 */
@Entity
@NamedQuery(name="Abonne.findAll", query="SELECT a FROM Abonne a")
public class Abonne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebutAbonnement;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFinAbonnement;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String email;

	private String nom;

	@Lob
	private String password;

	private String prenom;

	//bi-directional many-to-one association to Emprunt
	@OneToMany(mappedBy="abonne")
	private List<Emprunt> emprunts;

	public Abonne() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebutAbonnement() {
		return dateDebutAbonnement;
	}

	public void setDateDebutAbonnement(Date dateDebutAbonnement) {
		this.dateDebutAbonnement = dateDebutAbonnement;
	}

	public Date getDateFinAbonnement() {
		return dateFinAbonnement;
	}

	public void setDateFinAbonnement(Date dateFinAbonnement) {
		this.dateFinAbonnement = dateFinAbonnement;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public Emprunt addEmprunt(Emprunt emprunt) {
		getEmprunts().add(emprunt);
		emprunt.setAbonne(this);

		return emprunt;
	}

	public Emprunt removeEmprunt(Emprunt emprunt) {
		getEmprunts().remove(emprunt);
		emprunt.setAbonne(null);

		return emprunt;
	}

}
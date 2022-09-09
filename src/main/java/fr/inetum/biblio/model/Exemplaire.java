package fr.inetum.biblio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exemplaire database table.
 * 
 */
@Entity
@NamedQuery(name="Exemplaire.findAll", query="SELECT e FROM Exemplaire e")
public class Exemplaire implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String etatPhysique;

	private int numero;

	private String usageExemplaire;

	//bi-directional many-to-one association to Emprunt
	@ManyToOne
	@JoinColumn(name="idEmprunt")
	private Emprunt emprunt;

	//bi-directional many-to-one association to Oeuvre
	@ManyToOne
	@JoinColumn(name="idOeuvre")
	private Oeuvre oeuvre;

	public Exemplaire() {
	}

	public String getEtatPhysique() {
		return this.etatPhysique;
	}

	public void setEtatPhysique(String etatPhysique) {
		this.etatPhysique = etatPhysique;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUsageExemplaire() {
		return this.usageExemplaire;
	}

	public void setUsageExemplaire(String usageExemplaire) {
		this.usageExemplaire = usageExemplaire;
	}

	public Emprunt getEmprunt() {
		return this.emprunt;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	public Oeuvre getOeuvre() {
		return this.oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

}
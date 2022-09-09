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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEtatPhysique() {
		return etatPhysique;
	}

	public void setEtatPhysique(String etatPhysique) {
		this.etatPhysique = etatPhysique;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUsageExemplaire() {
		return usageExemplaire;
	}

	public void setUsageExemplaire(String usageExemplaire) {
		this.usageExemplaire = usageExemplaire;
	}

	public Emprunt getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

}
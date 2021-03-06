package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author PaolaLamb
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p"),
		@NamedQuery(name = "Pizza.findByCode", query = "SELECT p FROM Pizza p WHERE p.code = :codePizza") })
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ToString
	@Column(name = "reference", length = 10, nullable = false, unique = true)
	private String code;

	@ToString
	@Column(name = "libelle", length = 255, nullable = false, unique = false)
	private String nom;

	@ToString
	@Column(name = "prix", nullable = true, unique = false)
	private Double prix;

	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = true, unique = false)
	private CategoriePizza categoriePizza;

	@Column(name = "url_image", nullable = true, unique = false)
	private String urlImage;

	/**
	 * Pizza empty constructor
	 */
	public Pizza() {
		// Empty method to use with JPA
	}

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categoriePizza
	 */
	public Pizza(Integer id, String code, String nom, Double prix, CategoriePizza categoriePizza) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}

	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {
				ToString annotationTrouve = champ.getAnnotation(ToString.class);
				if (annotationTrouve != null) {

					sb.append(champ.get(this).toString() + " ");

				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "/!\\/!\\ Arguments, accès non valide(s) /!\\/!\\", e);
		}

		return sb.toString();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(code).toHashCode();

	}

	@Override
	public boolean equals(Object objet) {
		if (objet == null) {
			return false;
		}
		if (objet == this) {
			return true;
		}
		if (objet.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) objet;
		return new EqualsBuilder().append(id, rhs.getId()).append(code, rhs.getCode()).isEquals();
	}

}
package pl.com.mojafirma.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the Rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String rola;

	//bi-directional many-to-many association to Osoba
	@ManyToMany(mappedBy="rolas", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
	property = "id")
	private Set<Osoba> osobas = new HashSet<Osoba>();

	public Rola() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public Set<Osoba> getOsobas() {
		return this.osobas;
	}

	public void setOsobas(Set<Osoba> osobas) {
		this.osobas = osobas;
	}

}
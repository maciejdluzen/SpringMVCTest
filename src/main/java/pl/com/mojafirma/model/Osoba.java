package pl.com.mojafirma.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the Osoba database table.
 * 
 */
@Entity
@Table
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String haslo;

	private String imie;

	private String login;

	private String nazwisko;

	private Integer wiek;

	//bi-directional many-to-many association to Rola
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="Osoba_Rola"
		, joinColumns={
			@JoinColumn(name="osoba_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rola_id")
			}
		)
	private Set<Rola> rolas = new HashSet<Rola>();

	//bi-directional many-to-one association to Pomiar_Cisnienia
	@OneToMany(mappedBy="osoba", fetch=FetchType.EAGER)
	private Set<Pomiar_Cisnienia> pomiarCisnienias = new HashSet<Pomiar_Cisnienia>();

	public Osoba() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return this.wiek;
	}

	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}

	public Set<Rola> getRolas() {
		return this.rolas;
	}

	public void setRolas(Set<Rola> rolas) {
		this.rolas = rolas;
	}

	public Set<Pomiar_Cisnienia> getPomiarCisnienias() {
		return this.pomiarCisnienias;
	}

	public void setPomiarCisnienias(Set<Pomiar_Cisnienia> pomiarCisnienias) {
		this.pomiarCisnienias = pomiarCisnienias;
	}

	public Pomiar_Cisnienia addPomiarCisnienia(Pomiar_Cisnienia pomiarCisnienia) {
		getPomiarCisnienias().add(pomiarCisnienia);
		pomiarCisnienia.setOsoba(this);

		return pomiarCisnienia;
	}

	public Pomiar_Cisnienia removePomiarCisnienia(Pomiar_Cisnienia pomiarCisnienia) {
		getPomiarCisnienias().remove(pomiarCisnienia);
		pomiarCisnienia.setOsoba(null);

		return pomiarCisnienia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((haslo == null) ? 0 : haslo.hashCode());
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pomiarCisnienias == null) ? 0 : pomiarCisnienias.hashCode());
		result = prime * result + ((rolas == null) ? 0 : rolas.hashCode());
		result = prime * result + wiek;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Osoba)) {
			return false;
		}
		Osoba other = (Osoba) obj;
		if (haslo == null) {
			if (other.haslo != null) {
				return false;
			}
		} else if (!haslo.equals(other.haslo)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (imie == null) {
			if (other.imie != null) {
				return false;
			}
		} else if (!imie.equals(other.imie)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (nazwisko == null) {
			if (other.nazwisko != null) {
				return false;
			}
		} else if (!nazwisko.equals(other.nazwisko)) {
			return false;
		}
		if (pomiarCisnienias == null) {
			if (other.pomiarCisnienias != null) {
				return false;
			}
		} else if (!pomiarCisnienias.equals(other.pomiarCisnienias)) {
			return false;
		}
		if (rolas == null) {
			if (other.rolas != null) {
				return false;
			}
		} else if (!rolas.equals(other.rolas)) {
			return false;
		}
		if (wiek != other.wiek) {
			return false;
		}
		return true;
	}
	
	

}
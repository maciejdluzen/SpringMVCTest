package pl.com.mojafirma.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Pomiar_Cisnienia database table.
 * 
 */
@Entity
@NamedQuery(name="Pomiar_Cisnienia.findAll", query="SELECT p FROM Pomiar_Cisnienia p")
public class Pomiar_Cisnienia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="data_pomiaru")
	private Timestamp dataPomiaru;

	private Integer puls;

	private Integer rozkurczowe;

	private Integer skurczowe;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	public Pomiar_Cisnienia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataPomiaru() {
		return this.dataPomiaru;
	}

	public void setDataPomiaru(Timestamp dataPomiaru) {
		this.dataPomiaru = dataPomiaru;
	}

	public int getPuls() {
		return this.puls;
	}

	public void setPuls(Integer puls) {
		this.puls = puls;
	}

	public int getRozkurczowe() {
		return this.rozkurczowe;
	}

	public void setRozkurczowe(Integer rozkurczowe) {
		this.rozkurczowe = rozkurczowe;
	}

	public int getSkurczowe() {
		return this.skurczowe;
	}

	public void setSkurczowe(Integer skurczowe) {
		this.skurczowe = skurczowe;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}
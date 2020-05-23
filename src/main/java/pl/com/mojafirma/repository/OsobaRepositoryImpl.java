package pl.com.mojafirma.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.com.mojafirma.model.Osoba;

public class OsobaRepositoryImpl implements OsobaRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Osoba getOsobaById(Integer id) {
		return em.find(Osoba.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Osoba> getAllOsoby() {
		return em.createNamedQuery("Osoba.findAll").getResultList();
	}

	@Override
	public Boolean addOsoba(Osoba osoba) {
		if(osoba != null && getOsobaById(osoba.getId()) == null) {
			em.persist(osoba);
			return true;
		}
		return false;
	}

	@Override
	public Boolean editOsoba(Integer id, Osoba osoba) {
		Osoba os = getOsobaById(id);
		if(osoba != null && os != null) {
			os.setImie(osoba.getImie());
			os.setLogin(osoba.getLogin());
			os.setHaslo(osoba.getHaslo());
			os.setNazwisko(osoba.getNazwisko());
			os.setPomiarCisnienias(osoba.getPomiarCisnienias());
			os.setRolas(osoba.getRolas());
			os.setWiek(osoba.getWiek());
			return true;
		}
		return false;
	}

	@Override
	public Boolean removeOsoba(Integer id) {
		Osoba os = getOsobaById(id);
		if(os != null) {
			em.remove(os);
			return true;
		}
		return false;
	}

}

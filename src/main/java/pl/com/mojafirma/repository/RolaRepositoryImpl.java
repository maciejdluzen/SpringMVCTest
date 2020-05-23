package pl.com.mojafirma.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.com.mojafirma.model.Rola;

@Repository
@Transactional
public class RolaRepositoryImpl implements RolaRepository {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public Rola getRolaById(Integer id) {
		return em.find(Rola.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rola> getAllRole() {
		return em.createNamedQuery("Rola.findAll").getResultList();
	}

	@Override
	public Boolean addRola(Rola rola) {
		if(rola != null && getRolaById(rola.getId()) == null) {
			em.persist(rola);
			return true;
		}
		return false;
	}

	@Override
	public Boolean editRola(Integer id, Rola rola) {
		Rola ro = getRolaById(id);
		if(rola != null) {
			ro.setOsobas(rola.getOsobas());
			ro.setRola(rola.getRola());
			em.persist(ro);
			return true;
		}
		return false;
	}

	@Override
	public Boolean removeRola(Integer id) {
		Rola rola = getRolaById(id);
		if(rola != null) {
			em.remove(rola);
			return true;	
		}
		return false;
	}

}

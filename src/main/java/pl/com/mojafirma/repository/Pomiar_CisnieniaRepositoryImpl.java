package pl.com.mojafirma.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.com.mojafirma.model.Pomiar_Cisnienia;

@Repository
@Transactional
public class Pomiar_CisnieniaRepositoryImpl implements Pomiar_CisnieniaRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Pomiar_Cisnienia getPomiarById(Integer id) {
		return em.find(Pomiar_Cisnienia.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pomiar_Cisnienia> getAllPomiaryById() {
		return em.createNamedQuery("Pomiar_Cisnienia.findAll").getResultList();
	}

	@Override
	public Boolean addPomiar(Pomiar_Cisnienia pomiar) {
		if(pomiar != null && getPomiarById(pomiar.getId()) == null) {
			em.persist(pomiar);
			return true;
		}
		return false;
	}

	@Override
	public Boolean editPomiar(Integer id, Pomiar_Cisnienia pomiar) {
		// TODO Auto-generated method stub
		return null;
	}

}

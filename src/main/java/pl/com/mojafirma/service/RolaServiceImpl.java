package pl.com.mojafirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.com.mojafirma.model.Rola;
import pl.com.mojafirma.repository.RolaRepository;

@Service
@Transactional
public class RolaServiceImpl implements RolaService {

	@Autowired
	private RolaRepository rolaRepository;
	
	@Override
	public Rola getRolaById(Integer id) {
		return rolaRepository.getRolaById(id);
	}

	@Override
	public List<Rola> getAllRole() {
		return rolaRepository.getAllRole();
	}

	@Override
	public Boolean addRola(Rola rola) {
		return rolaRepository.addRola(rola);
	}

	@Override
	public Boolean editRola(Integer id, Rola rola) {
		return rolaRepository.editRola(id, rola);
	}

	@Override
	public Boolean removeRola(Integer id) {
		return rolaRepository.removeRola(id);
	}

}

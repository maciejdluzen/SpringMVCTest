package pl.com.mojafirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.com.mojafirma.model.Pomiar_Cisnienia;
import pl.com.mojafirma.repository.Pomiar_CisnieniaRepository;

@Service
@Transactional
public class Pomiar_CisnieniaServiceImpl implements Pomiar_CisnieniaService {

	@Autowired
	private Pomiar_CisnieniaRepository pomiarCisnieniaRepository;
	
	@Override
	public Pomiar_Cisnienia getPomiarById(Integer id) {
		return pomiarCisnieniaRepository.getPomiarById(id);
	}

	@Override
	public List<Pomiar_Cisnienia> getAllPomiary() {
		return pomiarCisnieniaRepository.getAllPomiaryById();
	}

	@Override
	public Boolean addPomiar(Pomiar_Cisnienia pomiar) {
		return pomiarCisnieniaRepository.addPomiar(pomiar);
	}

	@Override
	public Boolean editPomiar(Integer id, Pomiar_Cisnienia pomiar) {
		return pomiarCisnieniaRepository.editPomiar(id, pomiar);
	}

	@Override
	public Boolean removePomiar(Integer id) {
		return pomiarCisnieniaRepository.removePomiar(id);
	}

}

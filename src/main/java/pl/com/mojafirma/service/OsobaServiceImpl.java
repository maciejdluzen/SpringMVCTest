package pl.com.mojafirma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.com.mojafirma.model.Osoba;
import pl.com.mojafirma.repository.OsobaRepository;

@Service
@Transactional
public class OsobaServiceImpl implements OsobaService {

	@Autowired
	private OsobaRepository osobaRepository;
	
	@Override
	public Osoba getOsobaById(Integer id) {
		return osobaRepository.getOsobaById(id);
	}

	@Override
	public List<Osoba> getAllOsoby() {
		return osobaRepository.getAllOsoby();
	}

	@Override
	public Boolean addOsoba(Osoba osoba) {
		return osobaRepository.addOsoba(osoba);
	}

	@Override
	public Boolean editOsoba(Integer id, Osoba osoba) {
		return osobaRepository.editOsoba(id, osoba);
	}

	@Override
	public Boolean removeOsoba(Integer id) {
		return osobaRepository.removeOsoba(id);
	}

}

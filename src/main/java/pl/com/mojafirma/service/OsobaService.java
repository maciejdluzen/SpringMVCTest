package pl.com.mojafirma.service;

import java.util.List;

import pl.com.mojafirma.model.Osoba;

public interface OsobaService {

	Osoba getOsobaById(Integer id);
	
	List<Osoba> getAllOsoby();
	
	Boolean addOsoba(Osoba osoba);
	
	Boolean editOsoba(Integer id, Osoba osoba);
	
	Boolean removeOsoba(Integer id);
	
	
	
}

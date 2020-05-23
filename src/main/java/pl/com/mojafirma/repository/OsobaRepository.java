package pl.com.mojafirma.repository;

import java.util.List;

import pl.com.mojafirma.model.Osoba;

public interface OsobaRepository {
	
	Osoba getOsobaById(Integer id);
	
	List<Osoba> getAllOsoby();
	
	Boolean addOsoba(Osoba osoba);
	
	Boolean editOsoba(Integer id, Osoba osoba);
	
	Boolean removeOsoba(Integer id);

}

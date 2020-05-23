package pl.com.mojafirma.repository;

import java.util.List;

import pl.com.mojafirma.model.Rola;

public interface RolaRepository {

	Rola getRolaById(Integer id);
	
	List<Rola> getAllRole();
	
	Boolean addRola(Rola rola);
	
	Boolean editRola(Integer id, Rola rola);
	
	Boolean removeRola(Integer id);
	
}

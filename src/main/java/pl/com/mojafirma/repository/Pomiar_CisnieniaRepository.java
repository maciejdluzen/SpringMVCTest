package pl.com.mojafirma.repository;

import java.util.List;

import pl.com.mojafirma.model.Pomiar_Cisnienia;

public interface Pomiar_CisnieniaRepository {
	
	Pomiar_Cisnienia getPomiarById(Integer id);
	
	List<Pomiar_Cisnienia> getAllPomiaryById();
	
	Boolean addPomiar(Pomiar_Cisnienia pomiar);
	
	Boolean editPomiar(Integer id, Pomiar_Cisnienia pomiar);
	
	Boolean removePomiar(Integer id);
	
	List<Pomiar_Cisnienia> gellAllPomiaryByOsobaId(Integer id);
	
}

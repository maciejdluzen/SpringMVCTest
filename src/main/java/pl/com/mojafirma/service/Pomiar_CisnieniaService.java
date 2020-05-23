package pl.com.mojafirma.service;

import java.util.List;

import pl.com.mojafirma.model.Pomiar_Cisnienia;

public interface Pomiar_CisnieniaService {
	
Pomiar_Cisnienia getPomiarById(Integer id);
	
	List<Pomiar_Cisnienia> getAllPomiary();
	
	Boolean addPomiar(Pomiar_Cisnienia pomiar);
	
	Boolean editPomiar(Integer id, Pomiar_Cisnienia pomiar);
	
	Boolean removePomiar(Integer id);
	
}

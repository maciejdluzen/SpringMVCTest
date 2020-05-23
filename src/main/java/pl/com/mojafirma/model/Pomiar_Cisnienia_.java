package pl.com.mojafirma.model;

import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-11T19:42:40.753+0100")
@StaticMetamodel(Pomiar_Cisnienia.class)
public class Pomiar_Cisnienia_ {
	public static volatile SingularAttribute<Pomiar_Cisnienia, Integer> id;
	public static volatile SingularAttribute<Pomiar_Cisnienia, Timestamp> dataPomiaru;
	public static volatile SingularAttribute<Pomiar_Cisnienia, Integer> puls;
	public static volatile SingularAttribute<Pomiar_Cisnienia, Integer> rozkurczowe;
	public static volatile SingularAttribute<Pomiar_Cisnienia, Integer> skurczowe;
	public static volatile SingularAttribute<Pomiar_Cisnienia, Osoba> osoba;
}

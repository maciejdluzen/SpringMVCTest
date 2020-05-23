package pl.com.mojafirma.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-11T19:42:40.755+0100")
@StaticMetamodel(Rola.class)
public class Rola_ {
	public static volatile SingularAttribute<Rola, Integer> id;
	public static volatile SingularAttribute<Rola, String> rola;
	public static volatile SetAttribute<Rola, Osoba> osobas;
}

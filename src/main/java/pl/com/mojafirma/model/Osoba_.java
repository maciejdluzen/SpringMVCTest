package pl.com.mojafirma.model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-11T19:42:40.640+0100")
@StaticMetamodel(Osoba.class)
public class Osoba_ {
	public static volatile SingularAttribute<Osoba, Integer> id;
	public static volatile SingularAttribute<Osoba, String> haslo;
	public static volatile SingularAttribute<Osoba, String> imie;
	public static volatile SingularAttribute<Osoba, String> login;
	public static volatile SingularAttribute<Osoba, String> nazwisko;
	public static volatile SingularAttribute<Osoba, Integer> wiek;
	public static volatile SetAttribute<Osoba, Rola> rolas;
	public static volatile SetAttribute<Osoba, Pomiar_Cisnienia> pomiarCisnienias;
}

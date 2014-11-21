package omilab.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


// @Transactional automatisiert das Transaktionhandling
// (Transaktionen starten und am Ende der Methode commit aufrufen) 
// 
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	// Das Spring Data repository abstrahiert den Datenbankzugriff
	// Das CrudRepository ist ein Teil des Spring Data repositorys und bietet eine einfache Handhabung
	// für typische CRUD Funktionen (Create, Read, Update, Delete)

	// Man kann einfach beliebige Methoden erfinden. Diese werden anhand der Signatur interpretiert
	public User findByEmail(String email);
	
	public User findByName(String name);

}
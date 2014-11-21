package omilab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


// Die Entity Annotation beschreibt die Klasse als Spring Datenbank Entitaet
// Die Table Annotation beschreibt den Namen der Tabelle in der DB
// Die Tabelle hat drei Spalten (id, email, name)
@Entity
@Table(name = "users")
public class User {


  // Automatisch generierte ID für jeden User
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  

  @NotNull
  private String email;
  
 
  @NotNull
  private String name;


  
  public User() { }

  public User(long id) { 
    this.id = id;
  }
  

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} 
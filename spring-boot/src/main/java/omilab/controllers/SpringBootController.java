package omilab.controllers;

import omilab.models.User;
import omilab.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Macht das System bereit Web Request mittels Spring MVC anzunehmen
@RestController
public class SpringBootController {
    
	// Mapt den Path / zur Methode index()
    @RequestMapping("/")
    public String index() {
        return "Spring Boot erfolgreich gestartet";
    }
    
    // Mapt den Path /boot zur Methode boot()
    @RequestMapping("/boot/")
    public String boot() {
        return "Spring Boot!!!";
    }

    // Bindet automatisch die Klasse UserDao um sie intern automatisch initialisieren zu können wenn benötigt
    @Autowired
    private UserDao userDao;

    
    // Erstellen eines neuen Users und abspeichern in die DB
    // http://localhost:8080/create?email=mail@kersjes-online.de&name=Christian
    @RequestMapping("/create")
    public String create(String email, String name) {
      try {
        User user = new User(email, name);
        userDao.save(user);
      }
      catch (Exception ex) {
        return "Fehler beim erstellen des Users: " + ex.toString();
      }
      return "User erfolgreich erstellt";
    }
    

    // Loeschen eines Users anhand seiner ID
    // http://localhost:8080/delete?id=1
    @RequestMapping("/delete")
    public String delete(long id) {
      try {
        User user = new User(id);
        userDao.delete(user);
      }
      catch (Exception ex) {
        return "Error deleting the user:" + ex.toString();
      }
      return "User succesfully deleted!";
    }
    

    // Anzeigen der ID eines Users anhand seiner Email
    // http://localhost:8080/get-by-email?email=mail@kersj.es
    @RequestMapping("/get-by-email")
    public String getByEmail(String email) {
      String userId;
      try {
        User user = userDao.findByEmail(email);
        userId = String.valueOf(user.getId());
      }
      catch (Exception ex) {
        return "User nicht gefunden";
      }
      return "Die User ID ist: " + userId;
    }
    
    // Anzeigen der ID eines Users anhand seiner Email
    // http://localhost:8080/get-by-name?name=Christian
    @RequestMapping("/get-by-name")
    public String getByName(String name) {
      String userId;
      try {
        User user = userDao.findByName(name);
        userId = String.valueOf(user.getId());
      }
      catch (Exception ex) {
        return "User nicht gefunden";
      }
      return "Die User ID ist: " + userId;
    }


    // Update der Userdaten anhand der ID
    // http://localhost:8080/update?id=5&email=test@test.de&name=testuser
    @RequestMapping("/update")
    public String updateUser(long id, String email, String name) {
      try {
        User user = userDao.findOne(id);
        user.setEmail(email);
        user.setName(name);
        userDao.save(user);
      }
      catch (Exception ex) {
        return "Fehler beim aktualisieren der Userdaten: " + ex.toString();
      }
      return "User erfolgreich aktualisiert";
    }
    
    
}

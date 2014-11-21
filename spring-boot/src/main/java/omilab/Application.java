package omilab;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Definiert die Klasse als Teil der Bean Definition im Applikations Kontext
@Configuration

// Brint Spring Boot dazu, die Beans hinzu zufügen. Konfiguriert aufgrund des Classpath und der Klassen
// Normal wäre "@EnableWebMvc" für ein Spring MVC Projekt. Aber Boot macht dies von alleine wenn die
// spring-webmvc im Classpath vorhanden ist
@EnableAutoConfiguration

// Erlaubt es Spring nach anderen Komponenten, Konfigurationen und Services im omilab Package zu suchen. 
// Ermöglicht es z. B. den SpringBootController zu finden
@ComponentScan
public class Application {
    

	// Die main Methode nutzt Spring Boots SpringApplication.run Methode zum Starten der Application
	// Wie man sieht, muss keine einzige Zeile XML geschrieben werden. Kein Bean.xml und kein web.xml
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Liste der Beans, welche von Spring Boot unterstuetzt werden:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}

package omilab;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// erlaubt es z. B. alle Anfrage auf ein css Verzeichniss abzublocken
		http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().anyRequest()
				.fullyAuthenticated().and().formLogin();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {

		// In diesem Fall wird ein LDAP Server zur Authentication genutzt
		// Es sind aber verschiedene Authentication Methoden verfügbar
		// Z. B. auth.inMemoryAuthentication().withUser("user").password("passwort").roles("USER");
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.ldapAuthentication().userDnPatterns("uid={0},ou=user")
					.groupSearchBase("ou=groups").contextSource()
					.ldif("classpath:test-server.ldif");
					// anstelle von ldif auch .url().port möglich um auf ein bestehenden 
					// LDAP Service zugreifen zu koennen
		}
	}
}
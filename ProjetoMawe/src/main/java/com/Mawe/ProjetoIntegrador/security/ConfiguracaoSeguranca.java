package com.Mawe.ProjetoIntegrador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	/**
	 * @param serviceImplements da classe UserDetailsServiceImplements
	 */
	private @Autowired UserDetailsServiceImplements serviceImplemets;
	
	/**
	 * Nesta excessão, é feita a autenticação do protocólo LDAP em memória, através de um
	  User e um password 
	 * 
	 */
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.inMemoryAuthentication().withUser("admin").password(paswordEncoder().encode("admin")).authorities("ROLE_ADMIN");
 		auth.userDetailsService(serviceImplemets);
 	}
	
	/**
	 * É utilizada a interface de serviço para senhas de codificação. 
	 A implementação preferida para criptografar a senha é a BCryptPasswordEncoder.
	 * 
	 * @nomeobjeto paswordEncoder()
	 * @return Para a aplicação: Retorna um password criptográfado
	 */
	@Bean
	public PasswordEncoder paswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Nesta exceção, é utiliza uma configuração padrão para autenticar tudo o que há nos
	 procólos em html Cadastrar e Logar
	 * 
	 */
 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests()
 		.antMatchers("/**").permitAll()
 		.antMatchers(HttpMethod.POST , "/ProjetoMawe/Usuario/Cadastrar").permitAll()
 		.antMatchers(HttpMethod.POST, "/ProjetoMawe/Usuario/Logar").permitAll()
 		.antMatchers( HttpMethod.POST , "/produto/Cadastrar").permitAll()
 		.antMatchers(HttpMethod.GET, "/produto/buscar").permitAll()
 		.antMatchers( HttpMethod.GET , "/produto/buscar/{id}").permitAll()
 		.antMatchers(HttpMethod.PUT, "/produto/alterar").permitAll()
 		.antMatchers( HttpMethod.DELETE , "/produto/delete/{id}").permitAll()
 		.antMatchers(HttpMethod.GET, "/categoria/buscartodos").permitAll()
 		.antMatchers( HttpMethod.GET , "/categoria/buscarpeloid/**").permitAll()
 		.antMatchers(HttpMethod.DELETE, "/categoria/deletar/**").permitAll()
 		.antMatchers(HttpMethod.POST, "/categoria/Cadastrar").permitAll()
 		.antMatchers(HttpMethod.PUT, "/categoria/Alterar").permitAll()
 		.anyRequest().authenticated()
 		.and().httpBasic()
 		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
 		.and().cors()
 		.and().csrf().disable(); 			
 	}
}

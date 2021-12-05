package fr.uge.service_web.project.Ecorp.rest.conf;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.integrateur.fesevent.security.JwtAuthenticationFilter;

@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll()
		.antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**").permitAll().
		anyRequest().authenticated();
		}
	
	
	
}*/


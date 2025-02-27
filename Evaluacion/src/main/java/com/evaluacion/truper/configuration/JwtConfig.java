package com.evaluacion.truper.configuration;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.evaluacion.truper.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class JwtConfig {
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception{
		http.csrf().disable()
//		.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
					.requestMatchers("/auth").permitAll()
					.requestMatchers("/v3/api-docs/**","/swagger-ui/**","/swagger-ui.html").permitAll()
					.anyRequest().authenticated()
					)
			.cors(withDefaults())
			.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
			.sessionManagement((session)-> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) ;
		
		http
			.formLogin(withDefaults());
		
		http
			.httpBasic(withDefaults());
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfig) throws Exception{
		return authenticationConfig.getAuthenticationManager();
	}
}

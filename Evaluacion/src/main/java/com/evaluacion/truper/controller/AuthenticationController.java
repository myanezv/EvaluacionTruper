package com.evaluacion.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.evaluacion.truper.Utilities.JwtUtilService;
import com.evaluacion.truper.model.AuthenticationRequest;
import com.evaluacion.truper.model.AuthenticationResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtilService jwtUtilService;
	
	@PostMapping("/auth")
	@Operation(summary = "Autenticación", description = "Genera token de autenticación")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationReq){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
						authenticationReq.getContrasena()));
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationReq.getUsuario());
		
		final String token = jwtUtilService.generateToken(userDetails);
		
		return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.OK);
		
	}
}

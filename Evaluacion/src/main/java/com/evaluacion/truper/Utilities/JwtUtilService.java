package com.evaluacion.truper.Utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtilService {
	@Value("${jwt.secret}")
	private String JWT_SECRET_KEY;
	
	@Value("${jwt.expiration}")
	private long JWT_TOKEN_EXPIRATION;
	
	public String extractUsername(String token) { return extractClaim(token, Claims::getSubject); }
	
	public Date extractExpiration(String token) { return extractClaim(token, Claims::getExpiration); }
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		return claimsResolver.apply(extractAllClaims(token));
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
	    Map<String, Object> claims = new HashMap<>();
	    var rol = userDetails.getAuthorities().stream().collect(Collectors.toList()).get(0);
	    claims.put("rol", rol);
	    return createToken(claims, userDetails.getUsername());
	  }

	  private String createToken(Map<String, Object> claims, String subject) {

	    return Jwts
	        .builder()
	        .setClaims(claims)
	        .setSubject(subject)
	        .setIssuedAt(new Date(System.currentTimeMillis()))
	        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRATION))
	        .signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY)
	        .compact();
	  }

	  public boolean validateToken(String token, UserDetails userDetails) {
	    final String username = extractUsername(token);
	    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	  }
}

package opensnzTech.shopWindows.security;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import opensnzTech.shopWindows.service.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	  @Value("${shopwindows.app.jwtSecret}")
	  private String jwtSecret;

	  @Value("${shopwindows.app.jwtExpirationMs}")
	  private int jwtExpirationMs;

	  public String generateJwtToken(Authentication authentication) {

	    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

	    // Récupérer l'identifiant de PharmaLabo associé à l'utilisateur
	   // Long pharmaLaboId = userPrincipal.getPharmaLaboId();
	    String role = userPrincipal.getAuthorities().toString();
	 // Créer les claims du token
	    Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
	   claims.put("role", role);
	    
	    return Jwts.builder()
	            .setClaims(claims)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
	            .signWith(key(), SignatureAlgorithm.HS256)
	            .compact();
	  }
	  
	  private Key key() {
	    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	  }

	  //vérifier le jeton JWT jwt et renverra le nom d'utilisateur s'il est valide
	  public String getUserNameFromJwtToken(String token) {
		    return Jwts.parser().setSigningKey(key()).parseClaimsJws(token)
		            .getBody().getSubject();
		}

		public boolean validateJwtToken(String authToken) {
		    try {
		        Jwts.parser().setSigningKey(key()).parseClaimsJws(authToken);
		        return true;
		    } catch (MalformedJwtException e) {
		        logger.error("Invalide JWT token: {}", e.getMessage());
		    } catch (ExpiredJwtException e) {
		        logger.error("JWT token est expiré: {}", e.getMessage());
		    } catch (UnsupportedJwtException e) {
		        logger.error("JWT token est insupportable: {}", e.getMessage());
		    } catch (IllegalArgumentException e) {
		        logger.error("JWT claims string est vide: {}", e.getMessage());
		    }

		    return false;
		}

}

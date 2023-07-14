package opensnzTech.shopWindows.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import opensnzTech.shopWindows.service.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter{
	 @Autowired
	  private JwtUtils jwtUtils;

	  @Autowired
	  private UserDetailsServiceImpl userDetailsService;
	  
	  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
	  
	// la logique de filtrage des requêtes HTTP  
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			 
		      String jwt = parseJwt(request);
		      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
		        String username = jwtUtils.getUserNameFromJwtToken(jwt);

		        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		        UsernamePasswordAuthenticationToken authentication =
		            new UsernamePasswordAuthenticationToken(
		                userDetails,
		                null,
		                userDetails.getAuthorities());
		        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		        SecurityContextHolder.getContext().setAuthentication(authentication);
		      }
		    } catch (Exception e) {
		      logger.error("impossible de faire le set user pour l'authentification: {}", e);
		    }

		    filterChain.doFilter(request, response);
	}
	  private String parseJwt(HttpServletRequest request) {
		  //récupérer la valeur de l'en-tête "Authorization" de la requête HTTP.
		    String headerAuth = request.getHeader("Authorization");
		    //"Bearer " est souvent utilisé pour indiquer le type de jeton utilisé.
		    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
		      return headerAuth.substring(7); //retourne la chaine de caractere à partir du 7eme caractere 
		    }

		    return null;
		  }
}

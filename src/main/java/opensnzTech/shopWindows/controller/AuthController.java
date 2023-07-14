package opensnzTech.shopWindows.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import opensnzTech.shopWindows.beans.ERole;
import opensnzTech.shopWindows.beans.Role;
import opensnzTech.shopWindows.beans.User;
import opensnzTech.shopWindows.beans.request.LoginRequest;
import opensnzTech.shopWindows.beans.request.SignupRequest;
import opensnzTech.shopWindows.beans.response.JwtResponse;
import opensnzTech.shopWindows.beans.response.MessageResponse;
import opensnzTech.shopWindows.dao.RoleDao;
import opensnzTech.shopWindows.dao.UserDao;
import opensnzTech.shopWindows.security.JwtUtils;
import opensnzTech.shopWindows.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserDao userRepository;

	  @Autowired
	  RoleDao roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;

	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));

	  }

	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Username déjà utilisé!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email déjà utilisé!"));
	    }

	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(), 
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getGln(),
                signUpRequest.getAdresseCanton(),
                signUpRequest.getRsGoogleBusiness(),
                signUpRequest.getRsLinkedin(),
                signUpRequest.getRsFacebook(),
                signUpRequest.getRsInstagram(),
                signUpRequest.getNumeroTelephone(),
                signUpRequest.getGroupement(),
                signUpRequest.getHoraireOuverture());

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role laboRole = roleRepository.findByName(ERole.ROLE_LABORATOIRE)
	          .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
	      roles.add(laboRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
	          roles.add(adminRole);

	          break;
	        case "laboratoire":
	          Role modRole = roleRepository.findByName(ERole.ROLE_LABORATOIRE)
	              .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
	          roles.add(modRole);
	          break;
	        case "pharmacie":
		          Role pharmaRole = roleRepository.findByName(ERole.ROLE_PHARMACIE)
		              .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
		          roles.add(pharmaRole);
		      break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_PHARMACIE)
	              .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
}

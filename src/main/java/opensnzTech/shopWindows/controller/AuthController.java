package opensnzTech.shopWindows.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import opensnzTech.shopWindows.beans.ERole;
import opensnzTech.shopWindows.beans.PharmaLabo;
import opensnzTech.shopWindows.beans.Role;
import opensnzTech.shopWindows.beans.User;
import opensnzTech.shopWindows.beans.request.LoginRequest;
import opensnzTech.shopWindows.beans.request.SignupRequest;
import opensnzTech.shopWindows.beans.response.JwtResponse;
import opensnzTech.shopWindows.beans.response.MessageResponse;
import opensnzTech.shopWindows.beans.response.PharmaLaboResponse;
import opensnzTech.shopWindows.dao.PharmaLaboRepository;
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

	@Autowired
	private PharmaLaboRepository pharmaLaboRepository;

	
	//@Autowired
	//private UserDetailsServiceImpl userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println(userDetails.isIsvalid());
		if(userDetails.isIsvalid())
		{
			
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getPharmaLaboName(), userDetails.getEmail(), userDetails.getPassword(), roles,
					userDetails.getPersoGln(),
					userDetails.getPharmaLaboGln(),
					userDetails.getAdresseCanton(),
					userDetails.getPharmaLaboAdresseCanton(), userDetails.getRsGoogleBusiness(),
					userDetails.getPharmaLaboRsGoogleBusiness(), userDetails.getRsLinkedin(),
					userDetails.getPharmaLaboRsLinkedin(), userDetails.getRsFacebook(),
					userDetails.getPharmaLaboRsFacebook(), userDetails.getRsInstagram(),
					userDetails.getPharmaLaboRsInstagram(), userDetails.getNumeroTelephone(),
					userDetails.getPharmaLaboNumeroTelephone(), userDetails.getPharmaLaboGroupement(),
					userDetails.getPharmaLaboHoraireOuverture()));
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("Please wait for admin approval."));
		}

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		Role role;
		User user;
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	        return ResponseEntity.badRequest().body(new MessageResponse("Error: Username déjà utilisé!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	        return ResponseEntity.badRequest().body(new MessageResponse("Error: Email déjà utilisé!"));
	    }
	    // Vérifier si le code pharmaLaboGln existe
	    PharmaLabo pharmaLabo = pharmaLaboRepository.findByPharmaLaboGln(signUpRequest.getPharmaLaboGln());
     	 // Set user roles based on the selected role
	    String strRole = signUpRequest.getRole();
	    
        if (strRole == null || strRole.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Veuillez sélectionner un rôle."));
        }
        
        //retourne le role exact 
        role =setRoleUser(strRole);
	    if (pharmaLabo != null) {
	        if (!pharmaLabo.getRole().equals(strRole)) {
	            return ResponseEntity.badRequest().body(new MessageResponse("Error: Rôle invalide pour le code pharmaLaboGln fourni."));
	        }
	        // Si le code existe, ajoutez les données de la pharmacie/laboratoire à l'utilisateur
	         user = new User(signUpRequest.getUsername(), pharmaLabo.getPharmaLaboName(), signUpRequest.getEmail(),
	                encoder.encode(signUpRequest.getPassword()), signUpRequest.getPersoGln(),
	                signUpRequest.getPharmaLaboGln(), signUpRequest.getAdresseCanton(),
	                pharmaLabo.getPharmaLaboAdresseCanton(), signUpRequest.getRsGoogleBusiness(),
	                pharmaLabo.getPharmaLaboRsGoogleBusiness(), signUpRequest.getRsLinkedin(),
	                pharmaLabo.getPharmaLaboRsLinkedin(), signUpRequest.getRsFacebook(),
	                pharmaLabo.getPharmaLaboRsFacebook(), signUpRequest.getRsInstagram(),
	                pharmaLabo.getPharmaLaboRsInstagram(), signUpRequest.getNumeroTelephone(),
	                pharmaLabo.getPharmaLaboNumeroTelephone(), pharmaLabo.getPharmaLaboGroupement(),
	                pharmaLabo.getPharmaLaboHoraireOuverture());
	    }     

	    else {
	         user = new User(signUpRequest.getUsername(),
	        		signUpRequest.getPharmaLaboName(),
	        		signUpRequest.getEmail(),
	                encoder.encode(signUpRequest.getPassword()),
	                signUpRequest.getPersoGln(),
	                signUpRequest.getPharmaLaboGln(),
	                signUpRequest.getAdresseCanton(),
	                signUpRequest.getPharmaLaboAdresseCanton(),
	                signUpRequest.getRsGoogleBusiness(),
	                signUpRequest.getPharmaLaboRsGoogleBusiness(),
	                signUpRequest.getRsLinkedin(),
	                signUpRequest.getPharmaLaboRsLinkedin(),
	                signUpRequest.getRsFacebook(),
	                signUpRequest.getPharmaLaboRsFacebook(),
	                signUpRequest.getRsInstagram(),
	                signUpRequest.getPharmaLaboRsInstagram(),
	                signUpRequest.getNumeroTelephone(),
	                signUpRequest.getPharmaLaboNumeroTelephone(),
	                signUpRequest.getPharmaLaboGroupement(),
	                signUpRequest.getPharmaLaboHoraireOuverture());
	    }

        user.setRoles(Collections.singleton(role));
        userRepository.save(user);  
        return ResponseEntity.ok(new MessageResponse("User registered successfully, Your request is pending admin approval!"));
//	     else {
//	    	 signUpRequest.setIsvalidGln(false);
	    	// If the pharmaLaboGln does not exist, handle the error accordingly
//	    	return ResponseEntity.badRequest().body(new MessageResponse("Error: Regester again please!"));
	    	    
//	    }
	}

    @PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateIsValid(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);
        
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setIsvalid(user.isIsvalid());
             return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public Role setRoleUser(String strRole)
    {
    	Role role = null;
        switch (strRole) {
            case "Admin":
                role = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
                break;
            case "Laboratory":
                role = roleRepository.findByName(ERole.ROLE_LABORATOIRE)
                        .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
                break;
            case "Pharmacy":
                role = roleRepository.findByName(ERole.ROLE_PHARMACIE)
                        .orElseThrow(() -> new RuntimeException("Error: Role non trouvé."));
                break;
        }
        return role;
    }

    @GetMapping("/checkGln")
    public ResponseEntity<?> checkPharmaLaboGln(@RequestParam String pharmaLaboGln) {
        PharmaLabo pharmaLabo = pharmaLaboRepository.findByPharmaLaboGln(pharmaLaboGln);
        if (pharmaLabo != null) {
            return ResponseEntity.ok(new PharmaLaboResponse(true, pharmaLabo));
        } else {
            return ResponseEntity.ok(new PharmaLaboResponse(false, null));
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getNoneapprovedUsers")
    public List<User> approveUsers() {
    	List<User> users = new ArrayList<>();
        users = userRepository.findByIsvalid(false);
        return users;	
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUser")
    public Optional<User> getUsers(@RequestParam Long id) {
    	Optional<User> user;
        user = userRepository.findById(id);
        return user;	
    }
	
    
}

package opensnzTech.shopWindows.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	  public String allAccess() {
	    return "Public Content.";
	  }

	  @GetMapping("/user")
	  @PreAuthorize("hasRole('LABORATOIRE') or hasRole('PHARMACIE') or hasRole('ADMIN')")
	  public String userAccess() {
	    return "User Content.";
	  }

	  @GetMapping("/labo")
	  @PreAuthorize("hasRole('LABORATOIRE') or hasRole('ADMIN')")
	  public String laboAccess() {
	    return "LABORATOIRE Board.";
	  }
	  
	  @GetMapping("/pharma")
	  @PreAuthorize("hasRole('PHARMACIE') or hasRole('ADMIN')")
	  public String pharmaAccess() {
	    return "PHARMACIE Board.";
	  }

	  @GetMapping("/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public String adminAccess() {
	    return "Admin Board.";
	  }
}

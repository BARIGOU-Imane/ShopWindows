package opensnzTech.shopWindows.controller;

import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import opensnzTech.shopWindows.beans.Compmarketing;
import opensnzTech.shopWindows.beans.User;
import opensnzTech.shopWindows.dao.CompmarketingRepository;
import opensnzTech.shopWindows.dao.UserDao;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/labo")
public class CompmarketingController {
	
	@Autowired
	CompmarketingRepository compRepository;
	
	@Autowired
	UserDao userRepository;
	
	  @GetMapping("/compagnes")
	  public ResponseEntity<List<Compmarketing>> getAllComps(@RequestParam(required = false) String nameComp) {
	    try {
	      List<Compmarketing> compagnes = new ArrayList<Compmarketing>();

	      if (nameComp == null)
	    	  compRepository.findAll().forEach(compagnes::add);
	      else
	    	  compRepository.findByNameComp(nameComp).forEach(compagnes::add);

	      if (compagnes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/compagne/{id}")
	  public ResponseEntity<Compmarketing> getCompagnesById(@PathVariable("id") long id) {
	    Optional<Compmarketing> compDetails = compRepository.findById(id);

	    if (compDetails.isPresent()) {
	      return new ResponseEntity<>(compDetails.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PreAuthorize("hasRole('LABORATOIRE')")  
	  @PostMapping("/addComp")
	  public ResponseEntity<Compmarketing> createCompagnes(@RequestBody Compmarketing compagne) {
	      try {
	          Compmarketing _compagne = new Compmarketing(
	                  compagne.getStartDate(),
	                  compagne.getEndDate(),
	                  compagne.getNameComp(),
	                  compagne.getTypeComp(),
	                  compagne.getBrand(),
	                  compagne.getSeason());

	          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	          String username = authentication.getName();

	          User user = userRepository.findByUsername(username)
	                  .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec username: " + username));

	          _compagne.setUserLabo(user);

	          // Calculate the period between startDate and endDate
	          Period period = Period.between(
	                  compagne.getStartDate().toLocalDate(),
	                  compagne.getEndDate().toLocalDate()
	          );

	          // Store the period as a formatted string (e.g., "1Y 2M 15D")
	          String formattedPeriod = String.format("%dY %dM %dD", period.getYears(), period.getMonths(), period.getDays());
	          _compagne.setPeriod(formattedPeriod);

	          Compmarketing savedComp = compRepository.save(_compagne);

	          return new ResponseEntity<>(savedComp, HttpStatus.CREATED);
	      } catch (Exception e) {
	          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	   
	  @PreAuthorize("hasRole('LABORATOIRE')")
	  @PutMapping("/updateComp/{id}")
	  public ResponseEntity<Compmarketing> updateComp(@PathVariable("id") long id, @RequestBody Compmarketing compagne) {
	    Optional<Compmarketing> compDetails = compRepository.findById(id);

	    if (compDetails.isPresent()) {
	    	Compmarketing _compagne = compDetails.get();
	    	_compagne.setStartDate(compagne.getStartDate());
	    	_compagne.setNameComp(compagne.getNameComp());
	    	_compagne.setEndDate(compagne.getEndDate());
	    	_compagne.setTypeComp(compagne.getTypeComp());
	    	_compagne.setSeason(compagne.getSeason());
	    	_compagne.setBrand(compagne.getBrand());
	      return new ResponseEntity<>(compRepository.save(_compagne), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PreAuthorize("hasRole('LABORATOIRE')")
	  @DeleteMapping("/deleteComp/{id}")
	  public ResponseEntity<HttpStatus> deleteComp(@PathVariable("id") long id) {
	    try {
	    	compRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PreAuthorize("hasRole('LABORATOIRE')")
	  @DeleteMapping("/deleteAllComps")
	  public ResponseEntity<HttpStatus> deleteAllComps() {
	    try {
	    	compRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }

	  @GetMapping("/comps/name")
	  public ResponseEntity<List<Compmarketing>> findByNameComp(@RequestParam("nameComp") String nameComp) {
	    try {
	      List<Compmarketing> compagnes = compRepository.findByNameComp(nameComp);

	      if (compagnes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/comps/brand")
	  public ResponseEntity<List<Compmarketing>> findByBrand(@RequestParam("brand") String brand) {
	    try {
	      List<Compmarketing> compagnes = compRepository.findByBrand(brand);

	      if (compagnes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  
	  @GetMapping("/comps/type")
	  public ResponseEntity<List<Compmarketing>> findByTypeComp(@RequestParam("typeComp") String typeComp) {
	    try {
	      List<Compmarketing> compagnes = compRepository.findByTypeComp(typeComp);

	      if (compagnes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/comps/season")
	  public ResponseEntity<List<Compmarketing>> findBySeason(@RequestParam("season") String season) {
	    try {
	      List<Compmarketing> compagnes = compRepository.findBySeason(season);

	      if (compagnes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/comps/date")
	  public ResponseEntity<List<Compmarketing>> findByDate(
	          @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date startDate,
	          @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date endDate) {
	      try {
	          if (startDate.after(endDate)) {
	              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	          }

	          
	          List<Compmarketing> compagnes = compRepository.getAllBetweenDates(startDate, endDate);

	          if (compagnes.isEmpty()) {
	              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	          }
	          return new ResponseEntity<>(compagnes, HttpStatus.OK);
	      } catch (Exception e) {
	          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	  @GetMapping("/comps/period")
	  public ResponseEntity<List<Compmarketing>> findByPeriod(@RequestParam("period") String period) {
	      try {
	          List<Compmarketing> compagnes = compRepository.findByPeriod(period);

	          if (compagnes.isEmpty()) {
	              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	          }

	          return new ResponseEntity<>(compagnes, HttpStatus.OK);
	      } catch (Exception e) {
	          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	  @GetMapping("/getAllCompUser")
	  public ResponseEntity<List<Compmarketing>> findCompsByAuthUser() {
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          String username = authentication.getName();

          User user = userRepository.findByUsername(username)
                  .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec username: " + username));


	      if (user == null) {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }

	      List<Compmarketing> compagnes = compRepository.findByUserLabo(user);

	      if (compagnes.isEmpty()) {
	          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(compagnes, HttpStatus.OK);
	  }

	  

}

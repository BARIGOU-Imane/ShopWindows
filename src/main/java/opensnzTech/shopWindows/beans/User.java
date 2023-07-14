package opensnzTech.shopWindows.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  
  //***************************************************************//
  // Nouveaux champs ajoutés
  @NotBlank
  @Size(max = 13)
  @Column(unique = true)
  private String gln;

  @NotBlank
  @Size(max = 100)
  private String adresseCanton;

  @Size(max = 100)
  private String rsGoogleBusiness;

  @Size(max = 100)
  private String rsLinkedin;

  @Size(max = 100)
  private String rsFacebook;

  @Size(max = 100)
  private String rsInstagram;
  
  @NotBlank
  @Size(max = 20)
  private String numeroTelephone;
  
  @NotBlank
  @Size(max = 100)
  private String groupement;
  

  @Temporal(TemporalType.TIMESTAMP)
  private Date horaireOuverture;
  
  
  public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
		@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 13) String gln,
		@NotBlank @Size(max = 100) String adresseCanton, @Size(max = 100) String rsGoogleBusiness,
		@Size(max = 100) String rsLinkedin, @Size(max = 100) String rsFacebook, @Size(max = 100) String rsInstagram,
		@NotBlank @Size(max = 20) String numeroTelephone, @NotBlank @Size(max = 100) String groupement,
		Date horaireOuverture) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.gln = gln;
	this.adresseCanton = adresseCanton;
	this.rsGoogleBusiness = rsGoogleBusiness;
	this.rsLinkedin = rsLinkedin;
	this.rsFacebook = rsFacebook;
	this.rsInstagram = rsInstagram;
	this.numeroTelephone = numeroTelephone;
	this.groupement = groupement;
	this.horaireOuverture = horaireOuverture;
}

//getter et setter
  public String getGln() {
	return gln;
}

public void setGln(String gln) {
	this.gln = gln;
}

public String getAdresseCanton() {
	return adresseCanton;
}

public void setAdresseCanton(String adresseCanton) {
	this.adresseCanton = adresseCanton;
}

public String getRsGoogleBusiness() {
	return rsGoogleBusiness;
}

public void setRsGoogleBusiness(String rsGoogleBusiness) {
	this.rsGoogleBusiness = rsGoogleBusiness;
}

public String getRsLinkedin() {
	return rsLinkedin;
}

public void setRsLinkedin(String rsLinkedin) {
	this.rsLinkedin = rsLinkedin;
}

public String getRsFacebook() {
	return rsFacebook;
}

public void setRsFacebook(String rsFacebook) {
	this.rsFacebook = rsFacebook;
}

public String getRsInstagram() {
	return rsInstagram;
}

public void setRsInstagram(String rsInstagram) {
	this.rsInstagram = rsInstagram;
}

public String getNumeroTelephone() {
	return numeroTelephone;
}

public void setNumeroTelephone(String numeroTelephone) {
	this.numeroTelephone = numeroTelephone;
}

public String getGroupement() {
	return groupement;
}

public void setGroupement(String groupement) {
	this.groupement = groupement;
}

public Date getHoraireOuverture() {
	return horaireOuverture;
}

public void setHoraireOuverture(Date horaireOuverture) {
	this.horaireOuverture = horaireOuverture;
}


  //***************************************************************//
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}

package opensnzTech.shopWindows.beans.request;

import java.util.Date;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
	 @NotBlank
	  @Size(min = 2, max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  private Set<String> role;

	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;

	  
	  //***************************************************************//
	// Nouveaux champs ajoutés
	  @NotBlank
	  @Size(max = 13)
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

	  public Set<String> getRole() {
	    return this.role;
	  }

	  public void setRole(Set<String> role) {
	    this.role = role;
	  }

}

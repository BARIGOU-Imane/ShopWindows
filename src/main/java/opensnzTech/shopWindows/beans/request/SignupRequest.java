package opensnzTech.shopWindows.beans.request;

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

	private String role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	@NotBlank
	@Size(max = 13)
	private String persoGln;

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

	// **********************PHARMA_LABO**************************/
	
	@Size(max = 20)
	private String pharmaLaboName;
	

	
	@Size(max = 100)
	private String pharmaLaboAdresseCanton;

	@Size(max = 100)
	private String pharmaLaboRsGoogleBusiness;

	@Size(max = 100)
	private String pharmaLaboRsLinkedin;

	@Size(max = 100)
	private String pharmaLaboRsFacebook;

	@Size(max = 100)
	private String pharmaLaboRsInstagram;

	
	@Size(max = 20)
	private String pharmaLaboNumeroTelephone;

	
	@Size(max = 100)
	private String pharmaLaboGroupement;

	
	@Size(max = 20)
	private String pharmaLaboHoraireOuverture;
	
	private boolean isvalid = false;
	
	@Size(max = 13)
	//@Column(unique = true)
	private String pharmaLaboGln;
	// ***************************************************************//

	// getter setter
	public String getPersoGln() {
		return persoGln;
	}

	public void setPersoGln(String persoGln) {
		this.persoGln = persoGln;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPharmaLaboAdresseCanton() {
		return pharmaLaboAdresseCanton;
	}

	public void setPharmaLaboAdresseCanton(String pharmaLaboAdresseCanton) {
		this.pharmaLaboAdresseCanton = pharmaLaboAdresseCanton;
	}

	public String getPharmaLaboRsGoogleBusiness() {
		return pharmaLaboRsGoogleBusiness;
	}

	public void setPharmaLaboRsGoogleBusiness(String pharmaLaboRsGoogleBusiness) {
		this.pharmaLaboRsGoogleBusiness = pharmaLaboRsGoogleBusiness;
	}

	public String getPharmaLaboRsLinkedin() {
		return pharmaLaboRsLinkedin;
	}

	public void setPharmaLaboRsLinkedin(String pharmaLaboRsLinkedin) {
		this.pharmaLaboRsLinkedin = pharmaLaboRsLinkedin;
	}

	public String getPharmaLaboRsFacebook() {
		return pharmaLaboRsFacebook;
	}

	public void setPharmaLaboRsFacebook(String pharmaLaboRsFacebook) {
		this.pharmaLaboRsFacebook = pharmaLaboRsFacebook;
	}

	public String getPharmaLaboRsInstagram() {
		return pharmaLaboRsInstagram;
	}

	public void setPharmaLaboRsInstagram(String pharmaLaboRsInstagram) {
		this.pharmaLaboRsInstagram = pharmaLaboRsInstagram;
	}

	public String getPharmaLaboNumeroTelephone() {
		return pharmaLaboNumeroTelephone;
	}

	public void setPharmaLaboNumeroTelephone(String pharmaLaboNumeroTelephone) {
		this.pharmaLaboNumeroTelephone = pharmaLaboNumeroTelephone;
	}

	public String getPharmaLaboGroupement() {
		return pharmaLaboGroupement;
	}

	public void setPharmaLaboGroupement(String pharmaLaboGroupement) {
		this.pharmaLaboGroupement = pharmaLaboGroupement;
	}

	public String getPharmaLaboHoraireOuverture() {
		return pharmaLaboHoraireOuverture;
	}

	public void setPharmaLaboHoraireOuverture(String pharmaLaboHoraireOuverture) {
		this.pharmaLaboHoraireOuverture = pharmaLaboHoraireOuverture;
	}

	public String getPharmaLaboName() {
		return pharmaLaboName;
	}

	public void setPharmaLaboName(String pharmaLaboName) {
		this.pharmaLaboName = pharmaLaboName;
	}

	public boolean isIsvalid() {
		return isvalid;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	public String getPharmaLaboGln() {
		return pharmaLaboGln;
	}

	public void setPharmaLaboGln(String pharmaLaboGln) {
		this.pharmaLaboGln = pharmaLaboGln;
	}



}

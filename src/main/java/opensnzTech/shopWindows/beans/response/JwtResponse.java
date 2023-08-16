package opensnzTech.shopWindows.beans.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String password;
	private List<String> roles;
	private String persoGln;
	private String adresseCanton;
	private String rsGoogleBusiness;
	private String rsLinkedin;
	private String rsFacebook;
	private String rsInstagram;
	private String numeroTelephone;
	private String pharmaLaboName;
	private String pharmaLaboAdresseCanton;
	private String pharmaLaboRsGoogleBusiness;
	private String pharmaLaboRsLinkedin;
	private String pharmaLaboRsFacebook;
	private String pharmaLaboRsInstagram;
	private String pharmaLaboNumeroTelephone;
	private String pharmaLaboGroupement;
	private String pharmaLaboHoraireOuverture;
	private String validpharmaLaboGln;
//***********************************
	public JwtResponse(String accessToken,
			Long id,
			String username,
			String pharmaLaboName,
			String email,
			String password,
			List<String> roles,
			String persoGln,
			String validpharmaLaboGln,
			String adresseCanton,
			String pharmaLaboAdresseCanton,
			String rsGoogleBusiness,
			String pharmaLaboRsGoogleBusiness,
			String rsLinkedin,
			String pharmaLaboRsLinkedin,
			String rsFacebook,
			String pharmaLaboRsFacebook,
			String rsInstagram,
			String pharmaLaboRsInstagram,
			String numeroTelephone,
			String pharmaLaboNumeroTelephone,
			String pharmaLaboGroupement,
			String pharmaLaboHoraireOuverture) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.persoGln = persoGln;
		this.adresseCanton = adresseCanton;
		this.rsGoogleBusiness = rsGoogleBusiness;
		this.rsLinkedin = rsLinkedin;
		this.rsFacebook = rsFacebook;
		this.rsInstagram = rsInstagram;
		this.numeroTelephone = numeroTelephone;
		this.username = username;
		this.pharmaLaboName = pharmaLaboName;
		this.email = email;
		this.password = password;
		this.persoGln = persoGln;
		this.adresseCanton = adresseCanton;
		this.rsGoogleBusiness = rsGoogleBusiness;
		this.rsLinkedin = rsLinkedin;
		this.rsFacebook = rsFacebook;
		this.rsInstagram = rsInstagram;
		this.numeroTelephone = numeroTelephone;
		this.pharmaLaboAdresseCanton = pharmaLaboAdresseCanton;
		this.pharmaLaboRsGoogleBusiness = pharmaLaboRsGoogleBusiness;
		this.pharmaLaboRsLinkedin = pharmaLaboRsLinkedin;
		this.pharmaLaboRsFacebook = pharmaLaboRsFacebook;
		this.pharmaLaboRsInstagram = pharmaLaboRsInstagram;
		this.pharmaLaboNumeroTelephone = pharmaLaboNumeroTelephone;
		this.pharmaLaboGroupement = pharmaLaboGroupement;
		this.pharmaLaboHoraireOuverture = pharmaLaboHoraireOuverture;
	    this.setValidpharmaLaboGln(validpharmaLaboGln);

	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPharmaLaboName() {
		return pharmaLaboName;
	}

	public void setPharmaLaboName(String pharmaLaboName) {
		this.pharmaLaboName = pharmaLaboName;
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

	public String getValidpharmaLaboGln() {
		return validpharmaLaboGln;
	}

	public void setValidpharmaLaboGln(String validpharmaLaboGln) {
		this.validpharmaLaboGln = validpharmaLaboGln;
	}



}

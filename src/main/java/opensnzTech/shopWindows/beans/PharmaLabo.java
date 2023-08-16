package opensnzTech.shopWindows.beans;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pharma_labo")
public class PharmaLabo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String pharmaLaboName;

	// consition de jointure
	//@NotBlank
	@Size(max = 13)
	@Column(unique = true)
	private String pharmaLaboGln;

	@NotBlank
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

	@NotBlank
	@Size(max = 20)
	private String pharmaLaboNumeroTelephone;

	@NotBlank
	@Size(max = 100)
	private String pharmaLaboGroupement;

	@NotBlank
	@Size(max = 20)
	private String pharmaLaboHoraireOuverture; // il ne faut pas qu'il soit de type string

    @NotBlank
    @Size(max = 50) // Adjust the size based on the maximum length of the role
    private String role;
    
	// getter & setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPharmaLaboName() {
		return pharmaLaboName;
	}

	public void setPharmaLaboName(String pharmaLaboName) {
		this.pharmaLaboName = pharmaLaboName;
	}

	public String getPharmaLaboGln() {
		return pharmaLaboGln;
	}

	public void setPharmaLaboGln(String pharmaLaboGln) {
		this.pharmaLaboGln = pharmaLaboGln;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	// selon le role qui est soit phramacie soit labo on recupère les données

}

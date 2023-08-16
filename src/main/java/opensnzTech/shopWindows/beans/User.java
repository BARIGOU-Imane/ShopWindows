package opensnzTech.shopWindows.beans;

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

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 20)
	private String username;


	@Size(max = 50)
	@Email
	private String email;


	@Size(max = 120)
	private String password;


	@Size(max = 13)
	@Column(unique = true)
	private String persoGln;


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

	@Size(max = 20)
	private String numeroTelephone; 

	// **********************PHARMA_LABO**************************/
	
	@Size(max = 20)
	private String pharmaLaboName;
	

	//@Size(max = 13)
	//private String pharmaLaboGln;
	
	
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
	// **********************Si code gln n'est pas encore validé*************************//

	@Size(max = 13)
	private String pharmaLaboGln;
	
	private boolean isvalid = false;
	


	public User(@NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 20) String pharmaLaboName,
			@NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 13) String persoGln,
			@NotBlank @Size(max = 13) String pharmaLaboGln,
			@NotBlank @Size(max = 100) String adresseCanton,
			@NotBlank @Size(max = 100) String pharmaLaboAdresseCanton,
			@Size(max = 100) String rsGoogleBusiness,
			@Size(max = 100) String pharmaLaboRsGoogleBusiness,
			@Size(max = 100) String rsLinkedin,
			@Size(max = 100) String pharmaLaboRsLinkedin,
			@Size(max = 100) String rsFacebook,
			@Size(max = 100) String pharmaLaboRsFacebook,
			@Size(max = 100) String rsInstagram,
			@Size(max = 100) String pharmaLaboRsInstagram,
			@NotBlank @Size(max = 20) String numeroTelephone,
			@NotBlank @Size(max = 20) String pharmaLaboNumeroTelephone,
			@NotBlank @Size(max = 100) String pharmaLaboGroupement,
			@NotBlank @Size(max = 20) String pharmaLaboHoraireOuverture) {
		super();
		this.username = username;
		this.pharmaLaboName = pharmaLaboName;
		this.email = email;
		this.password = password;
		this.persoGln = persoGln;
//		this.pharmaLaboGln = pharmaLaboGln;
		this.pharmaLaboGln = pharmaLaboGln;
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
	}
	// ***************************************************************//


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "pharmaLaboGln", referencedColumnName = "pharmaLaboGln", insertable = false, updatable = false)
   // private PharmaLabo pharmaLabo;
	
	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

public User(String username, String email, String password, String persoGln,
			String adresseCanton, String rsGoogleBusiness, String rsLinkedin, String rsFacebook,
			String rsInstagram, String numeroTelephone) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.persoGln = persoGln;
		this.adresseCanton = adresseCanton;
		this.rsGoogleBusiness = rsGoogleBusiness;
		this.rsLinkedin = rsLinkedin;
		this.rsFacebook = rsFacebook;
		this.rsInstagram = rsInstagram;
		this.numeroTelephone = numeroTelephone;
	}

	//getter et setter
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

	public String getPharmaLaboName() {
		return pharmaLaboName;
	}

	public void setPharmaLaboName(String pharmaLaboName) {
		this.pharmaLaboName = pharmaLaboName;
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

	public String getAdresseCanton() {
		return adresseCanton;
	}

	public String getPersoGln() {
		return persoGln;
	}

	public void setPersoGln(String persoGln) {
		this.persoGln = persoGln;
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

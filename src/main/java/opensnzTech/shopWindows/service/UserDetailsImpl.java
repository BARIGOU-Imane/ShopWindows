package opensnzTech.shopWindows.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import opensnzTech.shopWindows.beans.User;

public class UserDetailsImpl implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private Long id;
	  private String username;
	  private String email;
	  @JsonIgnore
	  private String password;
	  private Collection<? extends GrantedAuthority> authorities;
	  private String persoGln;
	  private String adresseCanton;
	  private String rsGoogleBusiness;
	  private String rsLinkedin;
	  private String rsFacebook;
	  private String rsInstagram;
	  private String numeroTelephone;

//****************************************//
		//private Long pharmaLaboId;
		private String pharmaLaboGln;
		private String pharmaLaboName;
		private String pharmaLaboAdresseCanton;
		private String pharmaLaboRsGoogleBusiness;
		private String pharmaLaboRsLinkedin;
		private String pharmaLaboRsFacebook;
		private String pharmaLaboRsInstagram;
		private String pharmaLaboNumeroTelephone;
		private String pharmaLaboGroupement;
		private String pharmaLaboHoraireOuverture;
		private boolean isvalid = false;
//****************************************//
	  
	  public UserDetailsImpl(Long id,
			  boolean isvalid,
			  String username,
			  String pharmaLaboName,
			  String email,
			  String password,
		      Collection<? extends GrantedAuthority> authorities,
			  String persoGln,
			 String pharmaLaboGln,
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
		  //	this.pharmaLaboId= pharmaLaboId;
		  	this.id=id;
		  	this.username = username;
		    this.email = email;
		    this.password = password;
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
			this.pharmaLaboName = pharmaLaboName;
		    this.authorities = authorities;
		    this.isvalid = isvalid;
		    this.pharmaLaboGln=pharmaLaboGln;
		  }
	  
	  public static UserDetailsImpl build(User user) {
		  //stocker tous les roles dans une liste authorities
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());
		    //nv objet utilisateur qui contient l'autorité cad roles 
		    return new UserDetailsImpl(
		        user.getId(), 
		        user.isIsvalid(),
		        user.getUsername(), 
		        user.getPharmaLaboName(),
		        user.getEmail(),
		        user.getPassword(), 
		        authorities,
		        user.getPersoGln(),
		        user.getPharmaLaboGln(),
		        user.getAdresseCanton(),
		        user.getPharmaLaboAdresseCanton(),
		        user.getRsGoogleBusiness(),
		        user.getPharmaLaboRsGoogleBusiness(),
		        user.getRsLinkedin(),
		        user.getPharmaLaboRsLinkedin(),
		        user.getRsFacebook(),
		        user.getPharmaLaboRsFacebook(),
		        user.getRsInstagram(),
		        user.getPharmaLaboRsInstagram(),
		        user.getNumeroTelephone(),
		        user.getPharmaLaboNumeroTelephone(),
		        user.getPharmaLaboGroupement(),
		        user.getPharmaLaboHoraireOuverture()
		        );
		  }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	  public Long getId() {
		    return id;
		  }
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	 public String getEmail() {
		    return email;
	}
	
	  public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 public String getPersoGln() {
			return persoGln;
	}
	  
	public String getAdresseCanton() {
		return adresseCanton;
	}

	public String getRsGoogleBusiness() {
		return rsGoogleBusiness;
	}

	public String getRsLinkedin() {
		return rsLinkedin;
	}

	public String getRsFacebook() {
		return rsFacebook;
	}

	public String getRsInstagram() {
		return rsInstagram;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public String getPharmaLaboGln() {
		return pharmaLaboGln;
	}

	public String getPharmaLaboAdresseCanton() {
		return pharmaLaboAdresseCanton;
	}

	public String getPharmaLaboRsGoogleBusiness() {
		return pharmaLaboRsGoogleBusiness;
	}

	public String getPharmaLaboRsLinkedin() {
		return pharmaLaboRsLinkedin;
	}

	public String getPharmaLaboRsFacebook() {
		return pharmaLaboRsFacebook;
	}

	public String getPharmaLaboRsInstagram() {
		return pharmaLaboRsInstagram;
	}

	public String getPharmaLaboNumeroTelephone() {
		return pharmaLaboNumeroTelephone;
	}

	public String getPharmaLaboGroupement() {
		return pharmaLaboGroupement;
	}

	public String getPharmaLaboHoraireOuverture() {
		return pharmaLaboHoraireOuverture;
	}
	

	

	public String getPharmaLaboName() {
		return pharmaLaboName;
	}
	

	@Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }

	public boolean isIsvalid() {
		return isvalid;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	public void setPharmaLaboGln(String pharmaLaboGln) {
		this.pharmaLaboGln = pharmaLaboGln;
	}




	


}

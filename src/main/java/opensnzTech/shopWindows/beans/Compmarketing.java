package opensnzTech.shopWindows.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "marketingComp")
public class Compmarketing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "startDate")
	private Date startDate;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "nameComp")
	private String nameComp;

	@Column(name = "typeComp")
	private String typeComp;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "season")
	private String season;

	@Column(name = "period")
	private String period;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "user_comp", joinColumns = @JoinColumn(name = "comp_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User userLabo;


	public Compmarketing() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compmarketing(Date startDate, Date endDate, String nameComp, String typeComp, String brand,
			String season) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.nameComp = nameComp;
		this.typeComp = typeComp;
		this.brand = brand;
		this.season = season;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNameComp() {
		return nameComp;
	}

	public void setNameComp(String nameComp) {
		this.nameComp = nameComp;
	}

	public String getTypeComp() {
		return typeComp;
	}

	public void setTypeComp(String typeComp) {
		this.typeComp = typeComp;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public User getUserLabo() {
		return userLabo;
	}

	public void setUserLabo(User userLabo) {
		this.userLabo = userLabo;
	}
	
	
//	@Column(name = "responsibles")
//	private User responsibles;
	
	

}

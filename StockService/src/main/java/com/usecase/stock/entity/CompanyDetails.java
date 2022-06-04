package com.usecase.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="company_details")
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name= "company_code", nullable = false, unique = true)
	private String companyCode;
	
	@Column(name= "company_name", nullable = false)
	private String companyName;
	
	@Column(name= "company_ceo", nullable = false)
	private String companyCEO;
	
	@Column(name="company_turnover", nullable = false)
	private long companyTurnover;
	
	@Column(name="company_website", nullable = false)
	private String companyWebsite; 
	
	@Column(name="stock_exchange", nullable = false)
	private String stockExchange;

	public CompanyDetails() {
		
	}

	public CompanyDetails(int id, String companyCode, String companyName, String companyCEO,
			long companyTurnover, String companyWebsite, String stockExchange) {
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public long getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(long companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	@Override
	public String toString() {
		return "CompanyDetailsEntity [id=" + id + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", companyCEO=" + companyCEO + ", companyTurnover=" + companyTurnover + ", companyWebsite="
				+ companyWebsite + ", stockExchange=" + stockExchange + "]";
	} 	

}

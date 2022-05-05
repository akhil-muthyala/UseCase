package com.usecase.stock.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

@Entity
@Table(name = "STK_CMP")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STK_ID")
	int stockId;
	
	
	@Column(name = "STK_CMP_CODE")
	private String companyCode;
	
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "STK_PRICE")
	@NonNull
	private float stockPrice;
	
	
	@Column(name = "STK_UPD")
	private LocalDateTime stockUpdated;
	
	@PrePersist
	private void onCreate() {
		stockUpdated = LocalDateTime.now();
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public LocalDateTime getStockUpdated() {
		return stockUpdated;
	}

	public void setStockUpdated(LocalDateTime stockUpdated) {
		this.stockUpdated = stockUpdated;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", companyCode=" + companyCode + ", stockPrice=" + stockPrice
				+ ", stockUpdated=" + stockUpdated + "]";
	}
	
	
	
}

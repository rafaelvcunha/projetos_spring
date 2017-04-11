package br.com.rafaelvcunha.server.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Report {
	
	private int id;
	private BigDecimal sales;
	private int qty;
	private String staffName;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getSales() {
		return sales;
	}
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Report [id=" + id + ", sales=" + sales + ", qty=" + qty + ", staffName=" + staffName + ", date=" + date
				+ "]";
	}
	
	
	
}

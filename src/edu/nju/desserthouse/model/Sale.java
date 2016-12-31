package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale implements Serializable {

	@Id
	private int sid;
	private int member_account;
	private int planid;
	private String product_name;
	private int quantity;
	private double price;
	private int waiter_account;
	private String date;
	
	
	public Sale(){}
	public Sale(int member_account,int planid, String product_name, int quantity, double price, int waiter_account, String date) {
		super();
		this.member_account=member_account;
		this.planid = planid;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.waiter_account = waiter_account;
		this.date = date;
	}


	
	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getPlanid() {
		return planid;
	}


	public void setPlanid(int planid) {
		this.planid = planid;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getWaiter_account() {
		return member_account;
	}


	public void setMember_account(int member_account) {
		this.member_account = member_account;
	}
	public int getMember_account() {
		return waiter_account;
	}


	public void setWaiter_account(int waiter_account) {
		this.waiter_account = waiter_account;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	
	
	
}

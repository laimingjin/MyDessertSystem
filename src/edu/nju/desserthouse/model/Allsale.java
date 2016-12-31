package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allsale")
public class Allsale implements Serializable {

	@Id
	private int aid;
	private int member_account;
	private String planIDs;
	private String productIDs;
	private String productNames;
	private String prices;
	private String quantities;
	private double totalPrice;
	private String date;
	private int waiter_account;
	
	
	public Allsale(){}
	
	public Allsale( int member_account,String planIDs,String productIDs,String productNames, String prices, String quantities,double totalPrice,String date, int waiter_account){
		this.member_account = member_account;
		this.planIDs=planIDs;
		this.productIDs=productIDs;
		this.productNames=productNames;
		this.prices=prices;
		this.quantities=quantities;
		this.totalPrice = totalPrice;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		this.date = time;
		this.waiter_account=waiter_account;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getMember_account() {
		return member_account;
	}

	public void setMember_account(int member_account) {
		this.member_account = member_account;
	}
	public int getWaiter_account() {
		return waiter_account;
	}

	public void setWaiter_account(int waiter_account) {
		this.waiter_account = waiter_account;
	}

	public String getProductIDs() {
		return productIDs;
	}

	public void setProductIDs(String productIDs) {
		this.productIDs = productIDs;
	}
	public String getPlanIDs() {
		return planIDs;
	}

	public void setPlantIDs(String planIDs) {
		this.planIDs = planIDs;
	}

	public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}

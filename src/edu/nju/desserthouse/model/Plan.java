package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plan")
public class Plan implements Serializable {

	@Id
	private int planid;
	private int pid;
	private String shop;
	private Date starttime;
	private int quantity;
	private int status;
	private double price;
	private int wid;
	
	public Plan(){}
	public Plan(int planid,int pid,String shop,Date starttime,int quantity,int status,double price,int wid){
		this.planid=planid;
		this.pid=pid;
		this.shop=shop;
		this.starttime=starttime;
		this.quantity=quantity;
		this.status=status;
		this.price=price;
		this.wid=wid;
	}
	public Plan(int pid,String shop,Date starttime,int quantity,int status,double price,int wid){
		this.pid=pid;
		this.shop=shop;
		this.starttime=starttime;
		this.quantity=quantity;
		this.status=status;
		this.price=price;
		this.wid=wid;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	
	
	


	

	

	
}

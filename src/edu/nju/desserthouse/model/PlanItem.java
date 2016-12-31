package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planItem")
public class PlanItem implements Serializable{
	@Id
	private int piid;
	private int pid;
	private int quantity;
	private double price;
	
	public PlanItem(int pid, int quantity, double price) {
		this.pid = pid;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getPiid() {
		return piid;
	}
	public void setPiid(int piid) {
		this.piid = piid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	
	
}

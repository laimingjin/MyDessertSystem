package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiter")
public class Waiter implements Serializable {

	/**
	 * 
	 */
	
	private int wid;
	@Id
	private int account;
	private String name;
	private String password;
	private String level;//级别 分总店和分店即headquarters和subbranch
	private String shop;
	
	public String getLevel(){
		return level;
	}
	public void setLevel(String level){
		this.level=level;
	}
	public String getShop(){
		return shop;
	}
	public void setShop(String shop){
		this.shop=shop;
	}
	public Waiter(){}

	public Waiter(int account, String password){
		this.account = account;
		this.password = password;
	}
	
	public Waiter(String name,String password,String level,String shop){
		this.name = name;
		this.password = password;
		this.level=level;
		this.shop=shop;
	}
	public Waiter(int account,String name,String password,String level,String shop){
		this.account=account;
		this.name = name;
		this.password = password;
		this.level=level;
		this.shop=shop;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

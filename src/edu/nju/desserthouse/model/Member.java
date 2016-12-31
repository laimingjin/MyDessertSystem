package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable {

	/**
	 * 
	 */
	
	private int mid;
	@Id
	private int account;
	private String name;
	private String password;
	private long tel;
	private String card;
	private double money;
	private double allcost;
	private int level;
	private int status;
	private int credit;
	private Date date;
	private int age;
	private String gender;
	private String address;
	
	
	
	public Member(){}

	public Member(int account, String password){
		this.account = account;
		this.password = password;
	}
	public Member(long tel, String password){
		this.tel = tel;
		this.password = password;
	}
	public Member(String name, String password,
			long tel, int status, int credit,Date date,int age,String gender,String address) {
		super();
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.setStatus(status);
		this.credit = credit;
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.date=date;
	}
	
	public Member(int  account,String name, String password,long tel, int status, int credit,Date date,
			int age,String gender,String address,String card,double money,double allcost,int level) {
		super();
		this.account=account;
		this.name = name;
		this.password = password;
		this.setStatus(status);
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.card=card;
		this.tel = tel;
		this.credit = credit;
		this.date=date;
		this.money=money;
		this.allcost=allcost;
		this.level=level;
				
	}
	public Member(int  account,String name, String password,
			int age,String gender,String address,String card) {
		super();
		this.account=account;
		this.name = name;
		this.password = password;
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.card=card;
		
				
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int id) {
		this.mid = id;
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

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public double getAllcost() {
		return allcost;
	}

	public void setAllcost(double allcost) {
		this.allcost = allcost;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

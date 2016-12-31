package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="systemManager")
public class SystemManager implements Serializable{
	private int smid;
	@Id
	private int account;
	private String name;
	private String password;
	
	public SystemManager(){}

	public SystemManager(int account,String password){
		this.account = account;
		this.password = password;
	}
	
	public SystemManager(int account,String name, String password){
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public int getSmid() {
		return smid;
	}

	public void setSmid(int smid) {
		this.smid = smid;
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

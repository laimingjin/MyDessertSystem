package edu.nju.desserthouse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.w3c.dom.NamedNodeMap;

@Entity
@Table(name="shop")
public class Shop implements Serializable{
	
	private int sid;
	@Id
	private String name;
	private String tel;
	public Shop(){}
	public Shop(String name,String tel){
		this.name=name;
		this.tel=tel;
	}
public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}

package edu.nju.desserthouse.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.jndi.cosnaming.CNCtx;

@Entity
@Table(name="product")
public class Product implements Serializable{
	@Id
	private int pid;
	private String name;
	private String branch;//品牌
	private String catagory;//分类
	private String keepingcondition;//保鲜条件
	private String content;//内含量
	
	
	public Product(){}
	
	public Product(int pid){
		this.pid = pid;
	}

	public Product(String name,String branch,String catagory,String keepingcondition,String content){
		this.setName(name);
		this.setBranch(branch);
		this.setContent(content);
		this.setCatagory(catagory);
		this.setKeepingcondition(keepingcondition);
		
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getKeepingcondition() {
		return keepingcondition;
	}

	public void setKeepingcondition(String keepingcondition) {
		this.keepingcondition = keepingcondition;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	

}

package com.lyuke.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lyuke
 * @Date 2017-03-24 06:57
 */
@Entity
@Table(name="USER_ADDRESS")
public class Address {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer addressId;
	
	@Column(name="DESCRIPTION")
	private String des;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
	
}

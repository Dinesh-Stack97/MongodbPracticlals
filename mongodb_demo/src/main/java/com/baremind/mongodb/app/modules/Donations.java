package com.baremind.mongodb.app.modules;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Donations")
public class Donations {

	@Id
	private int id;

	

//	private String Foundations;

	private Double cash;

	//private String foodAndHeritage;

	private String type;

	private String subtype;

	private String donarName;

	private String templeId;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate createdDate;

	public Donations() {

		// TODO Auto-generated constructor stub
	}

	public Donations(int id, Double cash, String type, String subtype, String donarName, String templeId,
			LocalDate createdDate) {
		super();
		this.id = id;
		this.cash = cash;
		this.type = type;
		this.subtype = subtype;
		this.donarName = donarName;
		this.templeId = templeId;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	

}

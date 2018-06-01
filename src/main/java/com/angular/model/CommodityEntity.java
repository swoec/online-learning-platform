package main.java.com.angular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="commodity")
@Entity
public class CommodityEntity {
	private int id;
	private String name;
	private String depict;
	private String price;
	private int amount;
	private String manufacturer;
	private String img;
	private String type;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID", nullable = false, length = 11)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "CNAME", nullable = false, length = 80)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "CDEPICT", nullable = false, length = 200)
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	@Column(name = "CPRICE", nullable = false, length = 200)
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Column(name = "CAMOUNT", nullable = false, length = 11)
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column(name = "CMANUAL", nullable = false, length = 30)
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Column(name = "CIMG", nullable = true, length = 80)
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Column(name = "CTYPE", nullable = false, length = 11)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

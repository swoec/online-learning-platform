package main.java.com.angular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="orderlist")
@Entity
public class OrderlistEntity {
	private int id;
	private int commodityId;
	private int commodityCount;
	private int userId;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID", nullable = false, length = 11)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "CID", nullable = false, length = 11)
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	@Column(name = "CCOUNT", nullable = false, length = 11)
	public int getCommodityCount() {
		return commodityCount;
	}
	public void setCommodityCount(int commodityCount) {
		this.commodityCount = commodityCount;
	}
	@Column(name = "UID", nullable = false, length = 11)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

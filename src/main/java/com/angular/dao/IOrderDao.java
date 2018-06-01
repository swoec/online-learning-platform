package main.java.com.angular.dao;

import java.util.List;

import main.java.com.angular.model.OrderEntity;
import main.java.com.angular.model.OrderlistEntity;

public interface IOrderDao {
	
	public List<OrderlistEntity> getOrderbyId(int id);
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay, String orderList);
	public boolean addorderlist(int userId, String commodityIds, String commodityCounts);
	public List<OrderEntity> getOrdersById(int userid);
	public List<OrderEntity> getAllOrdersById();
	public List<OrderEntity> getSOrdersById(int userid,int flag);
	public boolean  setOrdersStatus(int userid,int orderid);
}

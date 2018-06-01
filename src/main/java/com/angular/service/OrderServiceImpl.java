package main.java.com.angular.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.IOrderDao;
import main.java.com.angular.model.OrderEntity;
import main.java.com.angular.model.OrderlistEntity;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	  @Resource
	  private IOrderDao orderDao;

	@Override
	public List<OrderlistEntity> getOrderbyId(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderbyId(id);
	}

	@Override
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay,
			String orderList) {
		// TODO Auto-generated method stub
		return orderDao.addorders(userId, address, phone, totalPrice, pay, orderList);
	}

	@Override
	public boolean addorderlist(int userId, String commodityIds, String commodityCounts) {
		// TODO Auto-generated method stub
		String[] commodityIdsArray = commodityIds.split(","); 
		String[] commodityId = commodityIds.split(",");
		boolean res=true;
		for(int i=0;i<commodityIdsArray.length;i++){
		 if(!orderDao.addorderlist(userId, commodityId[i], commodityCounts))
		    res=false;
		 break;
		}
		return res;
	}

	@Override
	public List<OrderEntity> getOrdersById(int userid) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersById(userid);
	}

	@Override
	public List<OrderEntity> getAllOrdersById() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrdersById();
	}

	@Override
	public List<OrderEntity> getSOrdersById(int userid, int flag) {
		// TODO Auto-generated method stub
		return orderDao.getSOrdersById(userid, flag);
	}

	@Override
	public boolean setOrdersStatus(int userid, int orderid) {
		// TODO Auto-generated method stub
		return orderDao.setOrdersStatus(userid, orderid);
	}
}

package main.java.com.angular.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.com.angular.model.OrderEntity;
import main.java.com.angular.model.OrderlistEntity;

@Component
@SuppressWarnings("unchecked")
@Repository("orderDao")
public class OrderDaoImpl implements IOrderDao {
	@Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<OrderlistEntity> getOrderbyId(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from OrderlistEntity where userId =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        
        return query.list();
	}

	@Override
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay,
			String orderList) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "insert into orders(UID,ADDR,PHONE,TPRICE,IPAY,ORDLIST) values(?,?,?,?,?,?)";
		Query query = session.createSQLQuery(hql);
        query.setInteger(0, userId);
        query.setString(1, address);
        query.setString(2, phone);
        query.setString(3, totalPrice);
        query.setString(4, pay);
        query.setString(5, orderList);
        if(1==query.executeUpdate())
		      return true;
        else return false;
	}

	@Override
	public boolean addorderlist(int userId, String commodityId, String commodityCount) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from OrderlistEntity where userId =? and commodityId =?";
		
		Query query = session.createQuery(hql);
		query.setInteger(0, userId);
		query.setInteger(1, Integer.parseInt(commodityId));	
		if(0==query.list().size()){
			String ihql ="insert into orderlist(UID,CID,CCOUNT) values(?,?,?)";
			
			Query insert = session.createSQLQuery(ihql);
			insert.setInteger(0, userId);
			insert.setInteger(1, Integer.parseInt(commodityId));
			insert.setInteger(2, Integer.parseInt(commodityCount));
			if(1==insert.executeUpdate())
			     return true;
			else return false;
		}else {
			OrderlistEntity order =(OrderlistEntity)query.list().get(0);
			int count =Integer.parseInt(commodityCount)+order.getCommodityCount();
		
			String uhql = "update orderlist set CCOUNT=? where UID="+userId+" and CID="+commodityId;			
			Query update = session.createSQLQuery(uhql);
			update.setInteger(0, count);
			if(1==update.executeUpdate())
				 return true;
			else return false;
		}
		
	}

	@Override
	public List<OrderEntity> getOrdersById(int userid) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from OrderEntity where userId =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, userid);
        
        return query.list();
	}

	@Override
	public List<OrderEntity> getAllOrdersById() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from OrderEntity ";
        Query query = session.createQuery(hql);
        
        
        return query.list();
	}

	@Override
	public List<OrderEntity> getSOrdersById(int userid, int flag) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from OrderEntity where userId =?"+" and pay=?";
        Query query = session.createQuery(hql);
        query.setInteger(0, userid);
        query.setInteger(1, flag);
        return query.list();
	}

	@Override
	public boolean setOrdersStatus(int userid, int orderid) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String uhql = "update orders set IPAY=? where UID="+userid+" and ORDID="+orderid;			
		Query update = session.createSQLQuery(uhql);
		update.setInteger(0, 1);
		if(1==update.executeUpdate())
			 return true;
		else return false;
		
	}

}

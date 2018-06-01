package main.java.com.angular.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.com.angular.model.CommentEntity;
import main.java.com.angular.model.CommodityEntity;

@Component
@SuppressWarnings("unchecked")
@Repository("commDao")
public class CommodityDaoImpl implements ICommodityDao {
	@Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<CommodityEntity> getCommById(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from CommodityEntity where id =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        
        return query.list();
        
		
	}

	@Override
	public List<CommodityEntity> getAllComm() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from CommodityEntity ";
        Query query = session.createQuery(hql);

        return query.list();
        
	}

	@Override
	public List<CommentEntity> getCommentbyId(int commid) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from CommentEntity where  commodityId = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0, commid);

        return query.list();
		
	}

	@Override
	public boolean addCommentbyId(int userId, int commodityID, String userName, String comment) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "insert into comment(USERID,COMMODITYID,UNAME,COMMENT) values(?,?,?,?)";
		Query query = session.createSQLQuery(hql);
        query.setInteger(0, userId);
        query.setInteger(1,commodityID);
        query.setString(2, userName);
        query.setString(3, comment);
        if(1==query.executeUpdate())
        	return true;
        else
		    return false;
	}

	@Override
	public List<CommodityEntity> searchComm(String keyword) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		//String hql = "select * from CommodityEntity where name like '%"+keyword+"%' union( select * from CommodityEntity where depict like '%"+keyword+"%')";
		String search ="from CommodityEntity where name like '%"+keyword+"%' or depict like '%"+keyword+"%')";
        Query query = session.createQuery(search);
        //query.setString(0, keyword);

        return query.list();
		
		
	}
    

}

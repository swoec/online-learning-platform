package main.java.com.angular.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.com.angular.model.UserEntity;


/**
 * @author ls
 */
@Component
@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
    @Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public boolean isExist(UserEntity user) {
        Session session = this.getSession();
        String hql = "from UserEntity where name =? and password = ?";
        Query query = session.createQuery(hql);
        query.setString(0, user.getName());
        query.setString(1, user.getPassword());
        
        if (query.list().size() >= 1) {
            return true;
        }
        return false;
    }

	@Override
	public boolean addUser(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "insert into custom(UNAME,UACCOUNT,UPASSWORD,UPHONE,USEX) values(?,?,?,?,?)";
		Query query = session.createSQLQuery(hql);
        query.setString(0, user.getName());
        query.setString(1, user.getName());
        query.setString(2, "123456");
        query.setString(3, user.getPhone());
        query.setString(4, user.getSex());
        if(1==query.executeUpdate())
		      return true;
        else return false;
	}

	@Override
	public List<UserEntity> fetchUser() {
		// TODO Auto-generated method stub
		  Session session = this.getSession();
	        String hql = "from UserEntity";
	        Query query = session.createQuery(hql);	        
		return query.list();
	}

	@Override
	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from custom  where UID="+id;
		Query query = session.createSQLQuery(hql);
		if(1 == query.executeUpdate())
		          return true;
		else return false;
	}

	@Override
	public boolean updateUser(int id, UserEntity user) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "update custom set UNAME=?,UACCOUNT=?,UPASSWORD=?,UPHONE=?,USEX=? where UID="+id;
		Query query = session.createSQLQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getName());
		query.setString(2, user.getPassword());
		query.setString(3, user.getPhone());
		query.setString(4, user.getSex());
		if(1 == query.executeUpdate())
		          return true;
		else return false;
		
	}

	@Override
	public UserEntity getUser(UserEntity user) {
		// TODO Auto-generated method stub
		 Session session = this.getSession();
	        String hql = "from UserEntity where name =? and password = ?";
	        Query query = session.createQuery(hql);
	        query.setString(0, user.getName());
	        query.setString(1, user.getPassword());
	        if (query.list().size() >= 1) 
	             return (UserEntity) query.list().get(0);
	        else return null;
	}   
}

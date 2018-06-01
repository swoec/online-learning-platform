/**  
* <p>Title: WordDaoImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 31/05/2018  
* @version 1.0  
*/  
package main.java.com.angular.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.com.angular.model.WordEntity;

/**  
* <p>Title: WordDaoImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 31/05/2018  
*/
@Component
@SuppressWarnings("unchecked")
@Repository("wordDao")
public class WordDaoImpl implements WordDao {
	
	@Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/* (non-Javadoc)
	 * @see main.java.com.angular.dao.WordDao#getWordById(int)
	 */
	@Override
	public List<WordEntity> getWordById(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from WordEntity where id =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        
        return query.list();
		
	}

	/* (non-Javadoc)
	 * @see main.java.com.angular.dao.WordDao#getWord()
	 */
	@Override
	public List<WordEntity> getWord() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from WordEntity where id =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, 1);

        return query.list();
	}

}

/**  
* <p>Title: WordDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 31/05/2018  
* @version 1.0  
*/  
package main.java.com.angular.dao;

import java.util.List;

import main.java.com.angular.model.WordEntity;



/**  
* <p>Title: WordDao</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 31/05/2018  
*/
public interface WordDao {
	public List<WordEntity> getWordById(int id);
	public List<WordEntity> getWord();
}

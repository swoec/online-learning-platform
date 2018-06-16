/**  
* <p>Title: StudentService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 16/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service;

import java.util.List;

import main.java.com.online.core.generic.GenericService;
import main.java.com.online.web.model.Students;

/**  
* <p>Title: StudentService</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 16/06/2018  
*/
public interface StudentService extends GenericService<Students, Long> {

	public List<Students> getAllStudent();
	public List<Students> getAllFriends(int uid);
	
}

/**  
* <p>Title: BookService.java</p>  
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
import main.java.com.online.web.model.Books;

/**  
* <p>Title: BookService</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 16/06/2018  
*/
public interface BookService extends GenericService<Books, Long> {

	public List<Books> getAllBook();
	public List<Books> getBookByID(int id);
	public List<Books> getBookByUser(int uid);
}

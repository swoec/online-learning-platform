/**  
* <p>Title: WordService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 2/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service;

import java.util.List;

import main.java.com.online.core.generic.GenericService;
import main.java.com.online.web.model.Permission;
import main.java.com.online.web.model.WordsWithBLOBs;





/**  
* <p>Title: WordService</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 2/06/2018  
*/
public interface WordService extends GenericService<WordsWithBLOBs, Long> {

	public List<WordsWithBLOBs> getWordbyId(int id);
	public List<WordsWithBLOBs> getAllWord();
	

}

/**  
* <p>Title: CommentService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 4/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service;

import java.util.List;

import main.java.com.online.core.generic.GenericService;
import main.java.com.online.web.model.Comments;

/**  
* <p>Title: CommentService</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 4/06/2018  
*/
public interface CommentService extends GenericService<Comments, Long> {
	public List<Comments> getCommentbytype(int type);
	public List<Comments> getCommentbyeid(int elementid);

}

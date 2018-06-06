/**  
* <p>Title: CommentController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 4/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.online.web.model.Comments;
import main.java.com.online.web.service.CommentService;

/**  
* <p>Title: CommentController</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 4/06/2018  
*/
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	private static Logger logger = Logger.getLogger(WordController.class);
	@Resource
	private CommentService comentservice;
	
	
	/*add for word list start*/
	@ResponseBody
    @RequestMapping(value="/comm/{id}" ,method = RequestMethod.POST)
    public List<Comments> getwordbyId( @PathVariable("id") int id){
		System.out.println("~~~~~~~~~~~~~");
		logger.info("------------comments/comm/"+id);
		return comentservice.getCommentbyeid(id);
		
    }
	
	@ResponseBody
    @RequestMapping(value="/add/" ,method = RequestMethod.POST)
    public int addCommentbyId( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		Comments com = new Comments();
		com.setEleid(Integer.parseInt(request.getParameter("eleid")));
		com.setUserid(Integer.parseInt(request.getParameter("uid")));
		com.setUname(request.getParameter("uname"));
		com.setComments(request.getParameter("comm"));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		com.setDtime(dateFormat.format(date));
		return comentservice.insert(com);
		
    }

}

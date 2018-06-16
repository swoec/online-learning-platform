/**  
* <p>Title: FileController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 12/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.online.web.model.Comments;

/**  
* <p>Title: FileController</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 12/06/2018  
*/
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/file")
public class FileController {
	private static Logger logger = Logger.getLogger(FileController.class);
	

	/**  
	 * <p>Title: uploadForm</p>  
	 * <p>Description: the start page of the small project </p>  
	 * @return  the upload page
	 */  
	@RequestMapping(value = "/index",method = RequestMethod.GET)
    public String uploadForm(){
        return "uploadForm";
    }
	
	@ResponseBody
    @RequestMapping(value="/add/" ,method = RequestMethod.POST)
    public int addCommentbyId( HttpServletRequest request, HttpServletResponse response){
		
		
		return 1;
		
    }

}

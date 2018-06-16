/**  
* <p>Title: BookController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 16/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.online.web.model.Books;
import main.java.com.online.web.service.BookService;

/**  
* <p>Title: BookController</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 16/06/2018  
*/
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/book")
public class BookController {
	private static Logger logger = Logger.getLogger(BookController.class);
	@Resource
	private BookService bookservice;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
    public String context(HttpServletRequest request, HttpServletResponse response) { 
    	System.out.println("-------------------------book---------");
    	logger.info("------book-----context---------");
       
        return "booklist";
    }

	@ResponseBody
    @RequestMapping(value="/booklist" ,method = RequestMethod.POST)
    public List<Books> getAllBooksDis(HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~book---~~~~~");
		
		return bookservice.getAllBook();
	
    }
}

/**  
* <p>Title: WordController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 2/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.controller;

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
import org.springframework.web.servlet.ModelAndView;

import main.java.com.online.web.model.WordsWithBLOBs;
import main.java.com.online.web.service.WordService;

/**  
* <p>Title: WordController</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 2/06/2018  
*/
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/word")
public class WordController {
	
	private static Logger logger = Logger.getLogger(WordController.class);
	@Resource
	private WordService wordservice;

	
	/*add for word list start*/
	@ResponseBody
    @RequestMapping(value="/word/{id}" ,method = RequestMethod.POST)
    public List<WordsWithBLOBs> getwordbyId( @PathVariable("id") int id){
		System.out.println("~~~~~~~~~~~~~");
		logger.info("------------word/word/"+id);
		return wordservice.getWordbyId(id);
		
    }
	
	@ResponseBody
    @RequestMapping(value="/wordlist" ,method = RequestMethod.POST)
    public List<WordsWithBLOBs> getAllword(HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		logger.info("-----------word---wordlist--------");
		return wordservice.getAllWord();
	
    }
	
	/* add for word list end */
	
	/**
     * 
     * 
     * @param session
     * @return
     */
	
    @RequestMapping(value = "/context", method = RequestMethod.GET)
    public String context(HttpServletRequest request, HttpServletResponse response) { 
    	System.out.println("-------------------------context---------");
    	logger.info("------word-----context---------");
        ModelAndView rw = new ModelAndView("wordlist");
		
        //return rw;
        return "wordlist";
    }
}

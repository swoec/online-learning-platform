package main.java.com.angular.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.model.UserEntity;
import main.java.com.angular.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
    private IUserService userService;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	@ResponseBody
    @RequestMapping(value="/init1")
    public ModelAndView login( HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView rw = new ModelAndView("login");
        return rw;
    }
	
    @ResponseBody
    @RequestMapping(value="/logins", method = RequestMethod.POST)
    public Map<String,Object> login(UserEntity user){
    	System.out.println("login");
    	System.out.println("user--kg");
    	System.out.println(user.getName()+user.getPassword());
        Map<String,Object> map = new HashMap<String,Object>();
        //System.out.println(user.toString());
        boolean loginResult=false;
        UserEntity users = userService.searchuser(user);
        if(users!=null){
        	HttpSession session = request.getSession(true);
            session.setAttribute("name", users.getName());
    		session.setAttribute("id", users.getId());
    		
    		 loginResult=true;
        }    
        map.put("loginResult", loginResult);
        return map;
    }
	
	@ResponseBody
    @RequestMapping(value="/user")
    public ModelAndView usr( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		
		ModelAndView rw = new ModelAndView("index");
		
        return rw;
    }
	
	@ResponseBody
    @RequestMapping(value="/usereng")
    public ModelAndView usreng( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		
		ModelAndView rw = new ModelAndView("wordlist");
		
        return rw;
    }
	
	@ResponseBody
    @RequestMapping(value="/users")
    public ModelAndView usrs( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("UserManagement");
		
        return rw;
    }

}

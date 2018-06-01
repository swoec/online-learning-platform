package main.java.com.angular.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.model.UserEntity;
import main.java.com.angular.service.IUserService;




/**
 * @author ls
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/user")
public class UserController{
    @Resource
    private IUserService userService;
       
    @ResponseBody
    @RequestMapping(value="/uadd", method = RequestMethod.POST)
    public boolean act(@RequestBody UserEntity user){
    	System.out.println("user add");
    	ModelAndView rw = new ModelAndView("UserManagement");
    	System.out.println(user.getName()+user.getPhone()+user.getSex());
    	boolean res = userService.adduser(user);
    	return res;	
    	
    }
    
    
    @ResponseBody
    @RequestMapping(value="/all")
    public List <UserEntity> fetchall(){
    	System.out.println("user add");
    	ModelAndView rw = new ModelAndView("UserManagement");
    	List <UserEntity> ulist = userService.fetchUser();    	
    	rw.addObject(ulist);
    	return ulist;	
    	
    }
    
    @ResponseBody
    @RequestMapping(value="/uupdate/{id}", method = RequestMethod.PUT)
    public boolean uupdate(@RequestBody UserEntity user,@PathVariable("id") int id){
    	System.out.println("~~~~~~~~update~~~~~~~~"+id);
    	System.out.println(user.getName());
    	return userService.updateUser(id, user);
    	
    }
    
    @ResponseBody
    @RequestMapping(value="/udel", method = RequestMethod.POST)
    public boolean udel(@RequestBody int id){
    	System.out.println(id);
    	return userService.delUser(id);
    }
    
    
}
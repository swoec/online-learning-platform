package main.java.com.angular.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.model.OrderEntity;
import main.java.com.angular.model.OrderlistEntity;
import main.java.com.angular.service.IOrderService;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/orders")
public class OrderController {
	@Resource
	private  IOrderService orderservice;
	

	@ResponseBody
    @RequestMapping(value="/index")
    public ModelAndView usrs( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		
		ModelAndView rw = new ModelAndView("index");
		
        return rw;
    }
	
	@ResponseBody
    @RequestMapping(value="/orderlist/{id}" ,method = RequestMethod.POST)
    public List<OrderlistEntity> getcommbyId( @PathVariable("id") int id){
		System.out.println("~~~~~~~id~~~~~~"+id);
		return orderservice.getOrderbyId(id);
		
    }
	
	
	@RequestMapping(value="addorders", method = RequestMethod.POST)
	@ResponseBody
	public boolean addForm( HttpServletRequest request, HttpServletResponse response) {
		int userId = Integer.parseInt( request.getParameter("userId") );
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String totalPrice = request.getParameter("totalPrice");
		String orderList = request.getParameter("orderList");
		String pay = "0";
		return orderservice.addorders(userId, address, phone, totalPrice, pay, orderList);
	}

	@RequestMapping(value="addorderlist", method = RequestMethod.POST)
	@ResponseBody
	public boolean addorderList( HttpServletRequest request, HttpServletResponse response) {
		int userId =0;
		if(null!=request.getParameter("userId")){
			 userId = Integer.parseInt(request.getParameter("userId").toString());
		}
		
		System.out.println("add orderList----"+userId);
		
		String commodityIds = request.getParameter("commodityIds");
		System.out.println("----commodityIds-------"+commodityIds);
		String commodityCounts = request.getParameter("commodityCounts");
		System.out.println(commodityIds+"------------"+commodityCounts);
		return orderservice.addorderlist(userId, commodityIds, commodityCounts);
	}
	
	

	@RequestMapping(value="getorders", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderEntity> getorders( HttpServletRequest request, HttpServletResponse response) {
		int userId =0;
		if(null!=request.getSession().getAttribute("id")){
			 userId = Integer.parseInt(request.getSession().getAttribute("id").toString());
		}
		return orderservice.getOrdersById(userId);
	}
	
	@RequestMapping(value="getallorders", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderEntity> getallorders( HttpServletRequest request, HttpServletResponse response) {
		
		return orderservice.getAllOrdersById();
	}
	
	
	@RequestMapping(value="setorders", method = RequestMethod.POST)
	@ResponseBody
	public boolean setorders( HttpServletRequest request, HttpServletResponse response) {
		int userId =0;
		if(null!=request.getParameter("userId")){
			 userId = Integer.parseInt(request.getParameter("userId"));
		}
		int orderid=0;
		if(null !=request.getParameter("orderId")){
			orderid =Integer.parseInt(request.getParameter("orderId"));
		}
		return orderservice.setOrdersStatus(userId, orderid);
	}
	
	
	
	
	
}

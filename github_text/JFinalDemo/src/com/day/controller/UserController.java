package com.day.controller;



import java.util.List;

import com.day.model.User;
import com.jfinal.core.Controller;

public class UserController extends Controller{
	
	 public void index(){
		// System.out.println("22222222222");
	        render("index.jsp");
	    }	
	 public void list(){
		// System.out.println("11111111111");
		  // 查询数据库列表
		        List<User> users=User.dao.find("select * from manage");
		        renderJson(users);

		  
	    }
	 //验证登录信息
	 public void submit(){
		 System.out.println("--------------");
	        String name = getPara("name");
	        String password = getPara("password");
	       
	        List users = User.dao.find("SELECT * FROM manage WHERE name = '"+name+"' AND password = '"+password+"'");
	        setAttr("users", users);
	        if(users.size()>3){
	            System.out.println("登录成功");
	             list();
	        }else{
	            System.out.println("登录失败");
	            index();
	        }
	      
	    }
	
}

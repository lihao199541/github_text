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
		  // ��ѯ���ݿ��б�
		        List<User> users=User.dao.find("select * from manage");
		        renderJson(users);

		  
	    }
	 //��֤��¼��Ϣ
	 public void submit(){
		 System.out.println("--------------");
	        String name = getPara("name");
	        String password = getPara("password");
	       
	        List users = User.dao.find("SELECT * FROM manage WHERE name = '"+name+"' AND password = '"+password+"'");
	        setAttr("users", users);
	        if(users.size()>3){
	            System.out.println("��¼�ɹ�");
	             list();
	        }else{
	            System.out.println("��¼ʧ��");
	            index();
	        }
	      
	    }
	
}

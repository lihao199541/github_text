package com.day.config;

import com.day.controller.UserController;
import com.day.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class BaseConfig extends JFinalConfig{

	@Override
	//   �������������ļ�
	public void configConstant(Constants me) {
		//������Ӷ�������ļ�
		loadPropertyFile("demo_config.txt");
		me.setViewType(ViewType.JSP);
		me.setDevMode(getPropertyToBoolean("devMode", false));
		
		
		
	}
	//  ���ò���ĵط�
	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
		me.add(cp);
	  
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		
		//ӳ��
		
		arp.addMapping("manage", User.class);
      
	}
// д URL �ĵط�
	@Override
	public void configRoute(Routes me) {
		
		me.add("/", UserController.class);
		me.add("/login", UserController.class,"");
	}
	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}



}

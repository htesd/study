package service;

import java.time.LocalDateTime;

import DAO.factorydates;
import DAO.idproducer;
import DAO.userdate;
import POjO.Agent;
import POjO.Manager;
import POjO.factory;
import POjO.user;

public class utils {
	public static LocalDateTime dt = LocalDateTime.now();
	
	
	public static user login(String account,String password){
		if(!userdate.users.isEmpty()){
		for (user user : userdate.users) {
			if(user.getaccount().equals(account)){
				if(user.getpassword().equals(password)){
					return user;
				}
			}
		}
		}else{
		return null;
		}
		return null;	
	}

//////////////
	public static String Agentregister(String name,String password,String email,String type,String account){
		if(!userdate.check(account)){
		Agent temp=new Agent();
		temp.setaccount(account);
		temp.setemail(email);
		temp.setid(Integer.parseInt("1"+idproducer.getid()));
		temp.setName(name);
		temp.setpassword(password);
		temp.settype(type);
		userdate.add(temp);
		return "注册成功！";
		}else{
			return "用户已经存在";
		}
		
	}
	public static String ManagerRegister(String name,String password,String email,String type,String account,int id,int fid){
		if(!userdate.check(account)){
		Manager temp=new Manager();
		temp.setaccount(account);
		temp.setemail(email);
		temp.setid(id);
		temp.setName(name);
		temp.setpassword(password);
		temp.settype(type);
		temp.setfid(fid);
		userdate.add(temp);
		return "注册成功！";
		}else{
			return "用户已经存在";
		}
		
	}
	public static String FactoryRegister(String name,String info,int uid,int fid ){
		factory temp=new factory();
		temp.setinfo(info);
		temp.setuserid(uid);
		temp.setname(name);
		temp.setfid(fid);
		if(!factorydates.check(name)){
			factorydates.add(temp);
			return "工厂成功添加";
		}else{
			return "工厂已经存在"; }
	}
	
	///
	
}

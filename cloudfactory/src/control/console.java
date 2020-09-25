package control;

import DAO.equipmentdate;
import DAO.etypedate;
import DAO.factorydates;
import DAO.idproducer;
import DAO.orderdate;
import DAO.pickorderdate;
import DAO.productdate;
import DAO.producttypedate;
import DAO.userdate;
import POjO.Manager;
import POjO.user;
import javafx.application.Application;
import view.administrator;
import view.login;

public class console {
	//差检索功能
	
public static user usering=new user();
public static Manager managering=new Manager();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pickorderdate pick= new pickorderdate();
       userdate userdate=new userdate();       
	   factorydates fdate=new factorydates();
	   idproducer idproducer=new idproducer();
	   productdate a=new productdate();
	   producttypedate b=new producttypedate();
	   orderdate c=new orderdate ();
	   etypedate d=new etypedate();
	   equipmentdate e=new equipmentdate();
	   Application.launch(login.class,args);
	   
		
	}

}

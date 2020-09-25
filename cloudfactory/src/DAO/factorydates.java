package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import POjO.Administrator;
import POjO.factory;
import POjO.user;

public class factorydates {

	public static ArrayList<factory> fs=new ArrayList<factory>();;
    static File factorydate = new File("factorydate.dat");
	 
	  public factorydates(){
		 
		 
	if(!factorydate.exists()){
		factory yun=new factory();
		yun.setfid(999);
		yun.setname("云工厂中心");
		yun.setinfo("用于设备租借");
		yun.setstatus(0);
		yun.setuserid(Integer.parseInt(Administrator.getname()));
		fs.add(yun);
		 try {
			factorydate.createNewFile();
			fs=new ArrayList<factory>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(factorydate.length()!=0){
		try {
			InputStream in=new FileInputStream(factorydate);
			ObjectInputStream input = new ObjectInputStream(in);
			 fs=(ArrayList)input.readObject();
			 input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(factory temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(factorydate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.getname())){
						fs.add(temp);
						output.writeObject(fs);
						output.flush();
						output.close();
						return true;
					} else{
						return false;
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
			}
			
			
		}


		
		public static boolean check(String name) {
			
			int check=0;
			if(fs.isEmpty()){
				return false;
			}else{
				for (factory user : fs) {
					if(user.getname().equals(name)){
						check=1;
					}
				}
				if(check==1){
					return true;
				}else{
					return false;
				}
			}
		}
		
		public static factory find(int id) {
			
			if(fs.isEmpty()){
			return null;
			}else{
				factory temp=null;
				for (factory user : fs) {
					if(user.getfid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

		public static boolean delete(int id) {
			
			if(fs.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   fs.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(factorydate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(fs);
					output.flush();
					output.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//////////////////////   
			   check=1;
		   }
		   if(check==1){
			   return true;
		   }else{
			   return false;
		   }
		   }
		}

}

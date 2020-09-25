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

import POjO.user;

public class userdate  {
public static ArrayList<user> users=new ArrayList<>();
 static File userdate = new File("userdate.dat");
 
  public userdate(){
	 
	 
if(!userdate.exists()){
	 try {
		userdate.createNewFile();
		users=new ArrayList<user>();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("文件初始化失败！！！");
	}

}else{
	
	if(userdate.length()!=0){
	try {
		InputStream in=new FileInputStream(userdate);
		ObjectInputStream input = new ObjectInputStream(in);
		
		this.users=(ArrayList)input.readObject();
		input.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
}
  }

	public static boolean add(user temp) {
		
		
		 try {
				OutputStream o=new FileOutputStream(userdate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				if(!check(temp.getaccount())){
					users.add(temp);
					output.writeObject(users);
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


	
	public static boolean check(String account) {
		
		int check=0;
		if(users.isEmpty()){
			return false;
		}else{
			for (user user : users) {
				if(user.getaccount().equals(account)){
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
	
	public static user find(int id) {
		
		if(users.isEmpty()){
		return null;
		}else{
			user temp=null;
			for (user user : users) {
				if(user.getid()==id){
					
					temp=user;
					
				    }
			      }
			return temp;
		}
	}

	public static boolean delete(int id) {
		
		if(users.isEmpty()){
			return false;
		}else{
			int check=0;
	   if(find(id)==null){
		 check=0;
	   }else{
		   users.remove(find(id));
		   OutputStream o;
		///////////////////////////////////   
		try {
			o = new FileOutputStream(userdate);
			ObjectOutputStream output = new ObjectOutputStream(o);
			   output.writeObject(users);
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

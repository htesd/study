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

import POjO.order;
import POjO.product;
import POjO.user;

public class orderdate 
{


	public static ArrayList<order> orders=new ArrayList<>();
	 static File orderdate = new File("orderdate.dat");
	 
	  public orderdate(){
		 
		 
	if(!orderdate.exists()){
		 try {
			 orderdate.createNewFile();
			 orders=new ArrayList<order>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(orderdate.length()!=0){
		try {
			InputStream in=new FileInputStream(orderdate);
			ObjectInputStream input = new ObjectInputStream(in);
			
			this.orders=(ArrayList)input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(order temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(orderdate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.getOid())){
						orders.add(temp);
						output.writeObject(orders);
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


		
		public static boolean check(int account) {
			
			int check=0;
			if(orders.isEmpty()){
				return false;
			}else{
				for (order user : orders) {
					if(user.getOid()==account){
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
		
		public static order find(int id) {
			
			if(orders.isEmpty()){
			return null;
			}else{
				order temp=null;
				for (order user : orders) {
					if(user.getOid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

public static boolean delete(int id) {
			
			if(orders.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   orders.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(orderdate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(orders);
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

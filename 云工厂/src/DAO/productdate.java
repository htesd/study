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

import POjO.product;
import POjO.user;

public class productdate {

	public static ArrayList<product> products=new ArrayList<>();
	 static File productdate = new File("productdate.dat");
	 
	  public productdate(){
		 
		 
	if(!productdate.exists()){
		 try {
			 productdate.createNewFile();
			 products=new ArrayList<product>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(productdate.length()!=0){
		try {
			InputStream in=new FileInputStream(productdate);
			ObjectInputStream input = new ObjectInputStream(in);
			
			this.products=(ArrayList)input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(product temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(productdate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.getpid())){
						products.add(temp);
						output.writeObject(products);
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
			if(products.isEmpty()){
				return false;
			}else{
				for (product user : products) {
					if(user.getpid()==account){
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
		
		public static product find(int id) {
			
			if(products.isEmpty()){
			return null;
			}else{
				product temp=null;
				for (product user : products) {
					if(user.getpid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

		public static boolean delete(int id) {
			
			if(products.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   products.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(productdate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(products);
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

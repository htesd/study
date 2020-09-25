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

import POjO.producttype;

public class producttypedate  {
	public static ArrayList<producttype> producttypes=new ArrayList<>();
	 static File producttypedate = new File("producttypedate.dat");
	 
	  public producttypedate(){
		  producttype et1=new producttype();
		  producttype et2=new producttype();
		  producttype et3=new producttype();
		  et1.settypeid(1);
		  et2.settypeid(2);
		  et3.settypeid(3);
		  et1.settypename("竹蜻蜓");
		  et2.settypename("任意门");
		  et3.settypename("空气炮");
		  producttypes.add(et1);
		  producttypes.add(et2);
		  producttypes.add(et3);
		 
	if(!producttypedate.exists()){
		 try {
			 producttypedate.createNewFile();
			 producttypes=new ArrayList<producttype>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(producttypedate.length()!=0){
		try {
			InputStream in=new FileInputStream(producttypedate);
			ObjectInputStream input = new ObjectInputStream(in);
			
			this.producttypes=(ArrayList)input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(producttype temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(producttypedate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.gettypeid())){
						producttypes.add(temp);
						output.writeObject(producttypes);
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
			if(producttypes.isEmpty()){
				return false;
			}else{
				for (producttype user : producttypes) {
					if(user.gettypeid()==account){
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
		
		public static producttype find(int id) {
			
			if(producttypes.isEmpty()){
			return null;
			}else{
				producttype temp=null;
				for (producttype user : producttypes) {
					if(user.gettypeid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

		public static boolean delete(int id) {
			
			if(producttypes.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   producttypes.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(producttypedate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(producttypes);
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

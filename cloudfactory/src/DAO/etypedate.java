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

import POjO.etype;
import POjO.user;

public class etypedate {

	
	
	public static ArrayList<etype> etypes=new ArrayList<>();
	 static File etypedate = new File("etypedate.dat");
	 
	  public etypedate(){
		 
		  etype et1=new etype();
		  etype et2=new etype();
		  etype et3=new etype();
		  et1.settypeid(1);
		  et2.settypeid(2);
		  et3.settypeid(3);
		  et1.settypename("哆啦口袋");
		  et2.settypename("永动机");
		  et3.settypename("宇宙机");
		  etypes.add(et1);
		  etypes.add(et2);
		  etypes.add(et3);
	if(!etypedate.exists()){
		 try {
			 etypedate.createNewFile();
			 etypes=new ArrayList<etype>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(etypedate.length()!=0){
		try {
			InputStream in=new FileInputStream(etypedate);
			ObjectInputStream input = new ObjectInputStream(in);
			
			this.etypes=(ArrayList)input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(etype temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(etypedate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.gettypeid())){
						etypes.add(temp);
						output.writeObject(etypes);
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
			if(etypes.isEmpty()){
				return false;
			}else{
				for (etype user : etypes) {
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
		
		public static etype find(int id) {
			
			if(etypes.isEmpty()){
			return null;
			}else{
				etype temp=null;
				for (etype user : etypes) {
					if(user.gettypeid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

		public static boolean delete(int id) {
			
			if(etypes.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   etypes.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(etypedate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(etypes);
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

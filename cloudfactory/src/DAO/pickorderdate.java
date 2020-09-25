package DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


import POjO.order;
import POjO.product;
import POjO.user;

public class pickorderdate {
	static File pickorderdate=new File("pickorderdate.dat");
	static Map<Integer,ArrayList> pickorders=new HashMap<>();
	static ArrayList<Integer> fids=new ArrayList();
	public pickorderdate(){
		 
		 
		if(!pickorderdate.exists()){
			 try {
				 pickorderdate.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件初始化失败！！！");
			}

		}else{
			
			if(pickorderdate.length()!=0){
			try {
				InputStream in=new FileInputStream(pickorderdate);
				ObjectInputStream input = new ObjectInputStream(in);
				
				pickorders=(Map)input.readObject();
				
				input.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
		}
		  }

			public static boolean add(int oid,int fid) {
				
				
				 try {
						OutputStream o=new FileOutputStream(pickorderdate);
						ObjectOutputStream output = new ObjectOutputStream(o);
						if(!check(oid,fid)){
							ArrayList<Integer> temp=null;
							temp=find(oid);
							pickorders.remove(oid);
							temp.add(fid);
							pickorders.put(oid,temp);
							
							output.writeObject(pickorders);
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
			public static boolean add(int oid) {
				
				
				 try {
						OutputStream o=new FileOutputStream(pickorderdate);
						ObjectOutputStream output = new ObjectOutputStream(o);
						if(!check(oid)){
							ArrayList<Integer> temp=new ArrayList();
							System.out.println("6");
							pickorders.put(oid, temp);
							
							
							output.writeObject(pickorders);
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

			
			public static boolean check(int oid,int fid) {
				
				int check=0;
				if(pickorders.isEmpty()){
					return false;
				}else{
					fids=pickorders.get(oid);
					if(fids==null){
						check=0;
					}else{
						for (Integer o : fids) {
							if(o==fid){
								check=1;
							}
						}
					}
					if(check==1){
						return true;
					}else{
						return false;
					}
				}
			}
         public static boolean check(int oid) {
        	 
				int check=0;
				if(pickorders.isEmpty()){
					return false;
				}else{
					fids=pickorders.get(oid);
					if(fids==null){
						System.out.println(fids==null);
						check=0;
					}else{
						
						check=1;
						
					}
					if(check==1){
						return true;
					}else{
						return false;
					}
				}
			}
			
			public static ArrayList<Integer> find(int oid) {
				 
				if(check(oid)){
				return 	fids=pickorders.get(oid);
				}else{
					return null;
				}
			}

	public static boolean delete(int id) {
				
				if(pickorders.isEmpty()){
					return false;
				}else{
					int check=0;
			       
				   pickorders.remove(id);
				   OutputStream o;
				///////////////////////////////////   
				try {
					o = new FileOutputStream(pickorderdate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					   output.writeObject(pickorders);
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
			   
			   if(check==1){
				   return true;
			   }else{
				   return false;
			   }
			   }
			}
}

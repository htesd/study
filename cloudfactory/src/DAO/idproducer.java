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
import java.util.Random;

import POjO.factory;
import POjO.user;

public class idproducer {
	public static ArrayList ids=new ArrayList();
	 static File iddate = new File("iddate.dat");
	 
	  public idproducer(){
		 
		 
	if(!iddate.exists()){
		 try {
			iddate.createNewFile();
			ids=new ArrayList<user>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(iddate.length()!=0){
		try {
			InputStream in=new FileInputStream(iddate);
			ObjectInputStream input = new ObjectInputStream(in);
			 ids=(ArrayList)input.readObject();
			 input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else{
			ids=new ArrayList();
		}
		
	}
	  }

	public static int getid(){
		Random r = new Random();
		int temp=r.nextInt(99999999);
		if(check(temp)){
			return getid();
		}else{
			add(temp);
			return temp;
		}
		
	}
			
	public static boolean add(int id) {
		
		
		 try {
				OutputStream o=new FileOutputStream(iddate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				if(!check(id)){
					ids.add(id);
					output.writeObject(ids);
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
		


		
		public static boolean check(int id) {
			
			int check=0;
			if(ids.isEmpty()){
				return false;
			}else{
				if(ids.contains(id)){
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


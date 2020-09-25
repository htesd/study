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

import POjO.equipment;
import POjO.product;
import POjO.user;
public class equipmentdate {
	public static ArrayList<equipment> equipments=new ArrayList<>();
	 static File equipmentdate = new File("equipmentdate.dat");
	 
	  public equipmentdate(){
		 equipment yun1=new equipment();
		 yun1.setfid(999);
		 yun1.seteid(Integer.parseInt("4"+idproducer.getid()));
		 yun1.setetid(1);
		 yun1.setInfo("3d打印,芜湖起飞");
		 yun1.setname("3d打印机");
		 yun1.setrenterid(0);
		 yun1.setworkstatus(0);
		 yun1.setspecification("超级口径");
		equipments.add(yun1); 
		//
		 equipment yun2=new equipment();
		 yun2.setfid(999);
		 yun2.seteid(Integer.parseInt("4"+idproducer.getid()));
		 yun2.setetid(1);
		 yun2.setInfo("想啥有啥,芜湖起飞");
		 yun2.setname("万能制造机");
		 yun2.setrenterid(0);
		 yun2.setworkstatus(0);
		 yun2.setspecification("超级节能");
		equipments.add(yun2); 
		//
		 equipment yun3=new equipment();
		 yun3.setfid(999);
		 yun3.seteid(Integer.parseInt("4"+idproducer.getid()));
		 yun3.setetid(1);
		 yun3.setInfo("降维打印,芜湖起飞");
		 yun3.setname("降维打印机");
		 yun3.setrenterid(0);
		 yun3.setworkstatus(0);
		 yun3.setspecification("超级2d");
		equipments.add(yun3); 
	if(!equipmentdate.exists()){
		 try {
			 equipmentdate.createNewFile();
			 equipments=new ArrayList<equipment>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件初始化失败！！！");
		}

	}else{
		
		if(equipmentdate.length()!=0){
		try {
			InputStream in=new FileInputStream(equipmentdate);
			ObjectInputStream input = new ObjectInputStream(in);
			
			this.equipments=(ArrayList)input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	  }

		public static boolean add(equipment temp) {
			
			
			 try {
					OutputStream o=new FileOutputStream(equipmentdate);
					ObjectOutputStream output = new ObjectOutputStream(o);
					if(!check(temp.geteid())){
						equipments.add(temp);
						output.writeObject(equipments);
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
			if(equipments.isEmpty()){
				return false;
			}else{
				for (equipment user : equipments) {
					if(user.geteid()==account){
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
		
		public static equipment find(int id) {
			
			if(equipments.isEmpty()){
			return null;
			}else{
				equipment temp=null;
				for (equipment user : equipments) {
					if(user.geteid()==id){
						
						temp=user;
						
					    }
				      }
				return temp;
			}
		}

		public static boolean delete(int id) {
			
			if(equipments.isEmpty()){
				return false;
			}else{
				int check=0;
		   if(find(id)==null){
			 check=0;
		   }else{
			   equipments.remove(find(id));
			   OutputStream o;
			///////////////////////////////////   
			try {
				o = new FileOutputStream(equipmentdate);
				ObjectOutputStream output = new ObjectOutputStream(o);
				   output.writeObject(equipments);
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

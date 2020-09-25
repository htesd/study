package POjO;

import java.io.Serializable;

public class factory implements Serializable{
private	int userid,fid,status=0;
private	String name,info;
public void setuserid(int n){
	this.userid=n;
}
public void setfid(int n){
	this.fid=n;
}
public void setstatus(int n){
	this.status=n;
}
public void setinfo(String s){
	this.info=s;
}
public void setname(String s ){
	this.name=s;
}
///
public int getuserid(){
	return this.userid;
}
public int getfid(){
	return this.fid;
}
public int getstatus(){
	return this.status;
}
public String getname(){
	return this.name;
}
public String getinfo(){
	return this.info;
}

}

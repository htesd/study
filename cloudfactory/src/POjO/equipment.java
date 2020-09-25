package POjO;

import java.io.Serializable;

public class equipment implements Serializable{
	
private int etid,fid,eid,workstatus,tentalstatus,renterid;

private String name,info,specification;

public void setetid(int n){
	this.etid=n;
}
public void setfid(int n){
	this.fid=n;
}
public void seteid(int n){
	this.eid=n;
}
public void setworkstatus(int n){
	this.workstatus=n;
}
public void settentalstatus(int n){
	this.tentalstatus=n;
}
public void setname(String s ){
	this.name=s;
}
public void setspecification(String s){
	this.specification=s;
}


///
public int getetid(){
	return this.etid;
}
public int geteid(){
	return this.eid;
}
public int getfid(){
	return this.fid;
}
public int getworkstatus(){
	return this.workstatus;
}
public int gettentalstatus(){
	return this.tentalstatus;
}
public String getname(){
	return this.name;
}

public String getspecification(){
	return this.specification;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public int getrenterid() {
	return renterid;
}
public void setrenterid(int renterid) {
	this.renterid = renterid;
}
}

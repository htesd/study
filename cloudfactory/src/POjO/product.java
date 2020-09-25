package POjO;

import java.io.Serializable;

public class product implements Serializable{
private int pid,ptid,oid;
private String name,info,specification;

public void setpid(int n){
	this.pid=n;
}
public void setptid(int n){
	this.ptid=n;
}
public void setoid(int n){
	this.oid=n;
}
public void setname(String s ){
	this.name=s;
}
public void setinfo(String s){
	this.info=s;
}

public void setspecification(String s){
	this.specification=s;
}
///
public int getpid(){
	return this.pid;
}
public int getptid(){
	return this.ptid;
}
public int getoid(){
	return this.oid;
}
public String getname(){
	return this.name;
}
public String getinfo(){
	return this.info;
}
public String getspecification(){
	return this.specification;
}
}

package POjO;

import java.io.Serializable;

public class user implements Serializable {
private String name,password,email,type,account;
int id;

public void setpassword(String s){
	this.password=s;
}
public void setemail(String s){
	this.email=s;
}
public void settype(String s){
	this.type=s;
}
public void setid(int s){
	this.id=s;
}
public void setaccount(String s){
	this.account=s;
}
/////////////////////////////////
public String getpassword(){
	return this.password ;
}
public String getemail(){
	return this.email;
}
public String gettype(){
	return this.type;
}
public int getid(){
	return this.id;
}
public String getaccount(){
	return this.account;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}

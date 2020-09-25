package POjO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class order implements Serializable{
private int oid,fid,productamount,agentid,status,eid;
private String consigneelname,consigneeladdress,consigneelcontact ,start,finish;

double price;
public double getprice() {
	return price;
}
public void setprice(double a){
	this.price=a;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getfid() {
	return fid;
}
public void setfid(int pid) {
	this.fid = pid;
}
public int getProductamount() {
	return productamount;
}
public void setProductamount(int productamount) {
	this.productamount = productamount;
}
public int getAgentid() {
	return agentid;
}
public void setAgentid(int agentid) {
	this.agentid = agentid;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getConsigneelname() {
	return consigneelname;
}
public void setConsigneelname(String consigneelname) {
	this.consigneelname = consigneelname;
}
public String getConsigneeladdress() {
	return consigneeladdress;
}
public void setConsigneeladdress(String consigneeladdress) {
	this.consigneeladdress = consigneeladdress;
}
public String getConsigneelcontact() {
	return consigneelcontact;
}
public void setConsigneelcontact(String consigneelcontact) {
	this.consigneelcontact = consigneelcontact;
}
public String getFinish() {
	return finish;
}
public void setFinish(String finish) {
	this.finish = finish;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}

}

package POjO;

import java.io.Serializable;

public class producttype implements Serializable{
public int typeid;
public String typename;
public void settypeid(int n){
this.typeid=n;	
}
public void  settypename(String s ){
this.typename=s;	
}
///
public int gettypeid(){
	return this.typeid;
}
public String gettypename(){
	return this.typename;
}
}

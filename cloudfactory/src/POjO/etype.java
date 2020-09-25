package POjO;

import java.io.Serializable;

public class etype implements Serializable {
int typeid;
String typename;
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

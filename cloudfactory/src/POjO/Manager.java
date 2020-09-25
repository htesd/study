package POjO;

import java.io.Serializable;

public class Manager extends user implements Serializable{
	private int fid=0;
	public void setfid(int n){
		this.fid=n;
	}
	public int getfid(){
		return this.fid;
	}
	
}

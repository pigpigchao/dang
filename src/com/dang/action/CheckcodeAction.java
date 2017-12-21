package com.dang.action;


public class CheckcodeAction extends BaseAction{
	private int number;
	private boolean ok=false;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String execute(){
		int answer=Integer.parseInt((String)session.get("answer"));
		if(number==answer){
			ok=true;
		}else{
			ok=false;
		}
		return "success";
	}
}

package esd.scos.model;

import java.io.Serializable;

public class User implements Serializable{

	private String account;//’À∫≈
	private String password;//√‹¬Î
	
	public User(String account,String password) {
		this.account=account;
		this.password=password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

package testNG;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNGFactory {
	private String userName;
	private String password;
	
	public TestNGFactory(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}
	
	@Test 
	public void LoginTest1() {
		System.out.println("UserName:"+userName +" password:"+password);
		
	}
	

	@Test 
	public void LoginTest2() {
		System.out.println("UserName:"+userName +" password:"+password);
		
	}
	
	
}

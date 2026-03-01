package testNG;

import org.testng.annotations.Factory;

public class LoginFactory {
	@Factory
	public Object[] createInstances(){
		return new Object[] {
				new TestNGFactory("admin1","pass1"),
				new TestNGFactory("admin2","pass2"),
				new TestNGFactory("admin3","pass3"),
				new TestNGFactory("admin3","pass4")
		};
	}
}

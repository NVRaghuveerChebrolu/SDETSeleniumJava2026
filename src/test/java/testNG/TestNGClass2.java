package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGClass2 {

	@Test
	public void testCase1() {
		System.out.println("inside testCase1 inside TestNGClass2");
		System.out.println("Thread ID from Class2:"+Thread.currentThread().getId());
	}
	
	@Test
	public void testCase2() {
		System.out.println("inside testCase2 inside TestNGClass2");
		System.out.println("Thread ID from Class2:"+Thread.currentThread().getId());
	}
	
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("inside before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("inside after class");
		
	}
}

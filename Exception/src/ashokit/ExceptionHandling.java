package ashokit;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionHandling {
	public void m1() {
		System.out.println(" arthamatic ex method called....");
		try {
		int i=10/0;
		}catch (ArithmeticException e) {
		System.out.println(e);
		}
	}
//2nd Answer
	public void m2() {
		System.out.println("nullpointer Exception called ....");
		try {
		String str = null;
		}catch (NullPointerException ee) {
			System.out.println(ee);
		}
	}
	public boolean file() {
		try {
			FileReader fr = new FileReader("c/file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public void m3() {
		//int[]arr = new arr[12345558];
	}
	
	public static void main(String[] args) {
		ExceptionHandling handling = new ExceptionHandling();
		handling.m1();
		handling.m2();
		handling.file();
	}
	
}

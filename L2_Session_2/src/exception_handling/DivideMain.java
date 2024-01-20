package exception_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DivideMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test();
		System.out.println("Before");
		
		int arr[] = new int[5];
		// to wrap it around a try catch
		try {
			throwsExample();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float f=0;
		try {
			
			// Reading 
			System.out.println(arr[5]);
			f=10/0;
			System.out.println("Divide by zero test"+10/0);
			File f1 = new File("/test.txt");
			//File myObj = new File("filename.txt");
		    Scanner myReader = new Scanner(f1);
				
		}catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// Close the database 
			//db.close();
			
		}
		//db.close();
		
		try {
			
		}finally {
			
		}
		
		System.out.println(f+"After");

	}
	
	public static void test() throws ArithmeticException{
		
		System.out.println("Divide by zero test"+10/0);
		
	}
	
	public static void throwsExample() throws FileNotFoundException {
		File f12 = new File("/test.txt");
		//File myObj = new File("filename.txt");
	    Scanner myReader2 = new Scanner(f12);
	    
	    System.out.println("Throws Example OUtput");
	}

}

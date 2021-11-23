package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataModelforlogin {
	
	UserLogin arr[] = new UserLogin[10];
	File myFile;
	Scanner sc;
	String type;
	public void GetLoginDataFromFile() {
		String u, p,t;
		UserLogin newObj;
		int i = 0;
		
		try {
			myFile = new File("data.txt");
			sc = new Scanner(myFile);
			while(sc.hasNextLine()) {
				u = sc.nextLine();
				p=sc.nextLine();
				t=sc.nextLine();
				newObj = new UserLogin(u,p,t);
				arr[i] = newObj;
				i++;
			}
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
			}
	}
	void initializetype(String type) {
		this.type = type;
	}
	String Gettype() {
		return type;
	}
}



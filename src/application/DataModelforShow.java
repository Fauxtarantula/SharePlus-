package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataModelforShow {

	
	Donor Darr[] = new Donor[10];
	File myFile;
	Scanner sc;
	String type;
	public int  l ;
	public void GetDonorDataFromFile() {
		String currentuser,type,iT,iN,skipline;
		int q;
		Donor newObj;
		int i = 0;
		//put in while loop
		
		try {
			myFile = new File("list.txt");
			sc = new Scanner(myFile);
			while(sc.hasNextLine()) {
				
				currentuser=sc.nextLine();
				type=sc.nextLine();
				iT=sc.nextLine();
				iN=sc.nextLine();
				q=sc.nextInt();
				newObj = new Donor(type,currentuser,iT,iN,q);
				Darr[i] = newObj;
				i++;
			}
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
			}
		l = i;
	}

}

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DoneeController {
	
	int intvalue;
	
	DataModelforShow datatoedit = new DataModelforShow();
	@FXML
	private TextField itemreceived;
	
	@FXML
	private TextField amtrequested;
	
	@FXML
	private Button submit2;
	@FXML
	void onReqSubmitClicked(ActionEvent event6) {
		intvalue = Integer.parseInt(amtrequested.getText());
		datatoedit.GetDonorDataFromFile();
		int ConValue = Integer.parseInt(amtrequested.getText());
		String ConIR  =itemreceived.getText();
		Stage currentstage = (Stage) submit2.getScene().getWindow();
		for(int i = 0; i < datatoedit.l;i++) {
			if(itemreceived.getText().equals(datatoedit.Darr[i].getItemName())) {
				Donee donee = new Donee("jack","Donee",ConIR,ConValue);
				//System.out.println(donee.calculate(datatoedit.Darr[i].getQuantity()));
				JOptionPane.showMessageDialog(null,donee.receive(),"You have received", JOptionPane.INFORMATION_MESSAGE);
				
				try {
					File myFile = new File("list.txt");
					//FileWriter fw = new FileWriter("list.txt",true);
					BufferedReader reader = new BufferedReader(new FileReader(myFile));
					String line = "", oldtext ="";
					while((line = reader.readLine())!=null) {
						oldtext += line +"\r\n";
					}
					reader.close();
					String s1 = String.valueOf(datatoedit.Darr[i].getQuantity());
					String s2 = String.valueOf(donee.calculate(datatoedit.Darr[i].getQuantity()));
					String newtext = oldtext.replaceAll(s1, s2);
					String removelastline = newtext.replaceFirst("[\n\r]+$", "");
		           FileWriter writer = new FileWriter("list.txt");
		            //writer.write(newtext);//deleye the last line
		            writer.write(removelastline);
		            writer.close();
				}
				catch(Exception E) {
					JOptionPane.showMessageDialog(null,"Please enter a valid quantity");
				}
			}
			
		}
		currentstage.close();
		
	}
}

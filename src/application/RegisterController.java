package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class RegisterController{
	
	@FXML
	private PasswordField CnfrmUserPwd;
	
	@FXML
    private PasswordField UserPwd;

    @FXML
    private TextField UserId;
    
    @FXML
    private RadioButton Donor;
    
    @FXML
    private RadioButton Donee;
    
    @FXML
    private ToggleGroup choices;
    
    @FXML
    private Button register;

	
	@FXML
	void onRegisterConfirmClicked(ActionEvent event2) {
		try {
			
			FileWriter fw = new FileWriter("data.txt",true);
			BufferedWriter pw = new BufferedWriter(fw);
			Stage currentstage = (Stage) register.getScene().getWindow();
			if(UserPwd.getText().equals(CnfrmUserPwd.getText())) {
				pw.newLine();
				pw.write(UserId.getText());		
				pw.newLine();
				pw.write(UserPwd.getText());
				pw.newLine();
				if(this.choices.getSelectedToggle().equals(this.Donee)) {
					pw.write("Donee");
				}
				else {
					pw.write("Donor");
				}
				//pw.newLine();
				pw.close();
				currentstage.close();
				
			}
			else {
				JOptionPane.showMessageDialog(null,"Please try again.");
				
			}
			
		}
		catch(Exception e){
			//System.out.print("Please fill in all the particulars.");
		}
	}
	
	
	public void initialize() {
		choices = new ToggleGroup();
		this.Donee.setToggleGroup(choices);
		this.Donor.setToggleGroup(choices);
	}
}

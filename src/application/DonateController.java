package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DonateController implements Initializable{
	
	String username;
	int intValue;
	
	@FXML
	private TextField itemname;
	
	@FXML
	private TextField quantity;
	
	@FXML
    private Button submit;
	
	@FXML
	private ComboBox<String> itemtype;
	private ObservableList<String> IList = FXCollections.observableArrayList("Gadget","Food");
	
	
	@FXML
	void onSubmitClicked(ActionEvent e) {
		System.out.print(username);
		
		try {
			intValue = Integer.parseInt(quantity.getText());
			FileWriter fw = new FileWriter("list.txt",true);
			BufferedWriter pw = new BufferedWriter(fw);
			Stage currentstage = (Stage) submit.getScene().getWindow();
			//pw.newLine();
			//pw.write("rakin");		//test
			pw.newLine();
			pw.write("rakin");
			pw.newLine();
			
			pw.write(itemtype.getValue());		
			pw.newLine();
			pw.write(itemname.getText());
			pw.newLine();
			
			pw.write(quantity.getText());
			pw.close();
			currentstage.close();
		}
		catch(Exception E) {
			JOptionPane.showMessageDialog(null,"Please enter a valid quantity");
		}
	}
	public void transferName(String uid) {
		// TODO Auto-generated method stub
		
		this.username = uid;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		itemtype.setItems((ObservableList<String>)IList);
		itemtype.getSelectionModel().select(null  );
	}
	
}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardController implements Initializable{

	String type,uid;
	String inventory = "";
	
	DataModelforShow dmfs = new DataModelforShow();
	
	@FXML
	private Button UserDonate;
	
	@FXML
	private Label name;
	
	
	@FXML
	private Button UserView;
	
	@FXML
	private Button SignOut;
	
	@FXML
	private TableView<Donor> DisplayView;
	
	@FXML
	private TableColumn<Donor, String> itemT;
	@FXML
	private TableColumn<Donor, String> Q;
	@FXML
	private TableColumn<Donor, String> itemN;
	
	//onButtonClick fo donate
	@FXML
	void onDonateClicked(ActionEvent event4) {
		
		try {
			if(type.equals("Donor")){
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Donor.fxml"));
	   			Scene sceneDash = new Scene(root);
	   			sceneDash.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	   			Stage RgWindow = new Stage();
	   			RgWindow.initModality(Modality.APPLICATION_MODAL);
	   			RgWindow.setScene(sceneDash);
	   			//JOptionPane.showMessageDialog(null,type);//to check
	   			UserView.setVisible(true);
	   			RgWindow.show();
			}
			else {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Donee.fxml"));
	   			Scene sceneDash = new Scene(root);
	   			sceneDash.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	   			Stage RgWindow = new Stage();
	   			RgWindow.initModality(Modality.APPLICATION_MODAL);
	   			RgWindow.setScene(sceneDash);
	   			//JOptionPane.showMessageDialog(null,type);//to check
	   			
	   			RgWindow.show();
	   			
			}
   			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//View inventory
	
	@FXML
	void onViewClicked(ActionEvent event5) {
		
		if(type.equals("Donor")) {
			
			for(int i = 0;i<dmfs.l;i++) {
				if(dmfs.Darr[i].getCurrentUser().equals(uid)) {
					inventory += dmfs.Darr[i].notification();
				}
			}
			JOptionPane.showMessageDialog(null,inventory,"My Inventory", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			UserView.setVisible(false);
		}
		
	}
	
	//onButtonClick for SignOut
	@FXML
	void onSignOutClicked(ActionEvent event3) {
		
		try {
			Stage thisstage = (Stage)SignOut.getScene().getWindow();
			JOptionPane.showMessageDialog(null,"See you again!");
			thisstage.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public void transferData(String type,String uid) {
		// TODO Auto-generated method stub
		this.type = type;
		this.uid = uid;
		
		name.setText(uid);
		if(type.equals("Donor")) {
			UserDonate.setText("Donate");
		}
		else {
			UserDonate.setText("Request");
		}
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		dmfs.GetDonorDataFromFile();
		itemT.setCellValueFactory(new PropertyValueFactory<Donor,String>("itemType"));
		itemN.setCellValueFactory(new PropertyValueFactory<Donor,String>("itemName"));
		Q.setCellValueFactory(new PropertyValueFactory<Donor,String>("quantity"));
		
		DisplayView.setItems(getPeople());
	}
	public ObservableList<Donor>  getPeople()
    {
        ObservableList<Donor> people = FXCollections.observableArrayList();
        
        for(int i = 0; i<dmfs.l;i++) {
        	people.add(dmfs.Darr[i]);
        	//System.out.print(dmfs.Darr[i].getCurrentUser()); // solve later
        }
        
        return people;
    }
	
	
	
	
}

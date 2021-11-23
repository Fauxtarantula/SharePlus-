package application;


import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;


public class SampleController {
	
	
	static int count =0;
	DataModelforlogin df = new DataModelforlogin();
	DataModelforShow dmf = new DataModelforShow();
	//String types
	
	
	@FXML
    private PasswordField txtPwd;

    @FXML
    private TextField txtLogin;

   @FXML
    void onLoginClicked(ActionEvent event) {
    	df.GetLoginDataFromFile();
    	
    	int found = 0;
    	for(int i = 0;i<3;i++) {
    		if (txtLogin.getText().equals(df.arr[i].uid)) {
    			found = 1;
    		       if (txtPwd.getText().equals(df.arr[i].pwd)) {
    		    	   try {
    		    		    
	    		   			//AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    		    		   	FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
	    		   			AnchorPane root = (AnchorPane)loader.load();
    		    		   	Scene sceneDash = new Scene(root);
	    		   			sceneDash.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    		   			Stage RgWindow = new Stage();
	    		   			RgWindow.initModality(Modality.APPLICATION_MODAL);
	    		   			RgWindow.setScene(sceneDash);
	    		   			RgWindow.show();
	    		   			
	    		   			DashboardController controller = loader.getController();
	    		   			controller.transferData(df.arr[i].type,df.arr[i].uid);
	    		   			
	    		   			/*DonateController dcontroller = loader.getController();
	    		   			dcontroller.transferName(df.arr[i].uid);*/
	    		   	    	   			
	    		   			
    		   		} catch (IOException e) {
    		   			// TODO Auto-generated catch block
    		   			e.printStackTrace();
    		   		}
    		          
    		       }
    		      
    		       else {
    		       JOptionPane.showMessageDialog(null,"Incorrect password.");
    		       }
    		       //count++;
    		       break;
    		    }
    		}
    	//df.initializetype(count);
    	if(found == 0) {
		       JOptionPane.showMessageDialog(null,"No such login ID.");
		    }
    

    }
   //Set up register button
    @FXML
    void onRegisterClicked(ActionEvent ev1) {

		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Registration.fxml"));
			Scene sceneRg = new Scene(root);
			sceneRg.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage RgWindow = new Stage();
			RgWindow.initModality(Modality.APPLICATION_MODAL);
			RgWindow.setScene(sceneRg);
			RgWindow.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}

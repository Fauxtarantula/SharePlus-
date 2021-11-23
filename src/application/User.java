package application;

import javafx.beans.property.SimpleStringProperty;

public class User {
	
	private SimpleStringProperty currentuser;
	private SimpleStringProperty type;
	
	User(String type,String currentuser){
		this.type = new SimpleStringProperty(type);
		this.currentuser=new SimpleStringProperty(currentuser);
		
	}
	
	

    public void setUserType(String type) {
        this.type = new SimpleStringProperty(type);
    }

    public String getUserType() {
        return type.get();
    }
    public void setCurrentUser(String currentuser) {
        this.currentuser = new SimpleStringProperty(currentuser);
    }
	public String getCurrentUser() {
        return currentuser.get();
    }

    
}

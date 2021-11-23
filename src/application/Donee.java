package application;

import javafx.beans.property.SimpleStringProperty;

public class Donee extends User{

	private SimpleStringProperty itemReceived;
	private int amtRetrieved;
	Donee(String currentuser, String type,String itemReceived,int amtRetrieved) {
		super(currentuser, type);
		// TODO Auto-generated constructor stub
		this.itemReceived = new SimpleStringProperty(itemReceived);
		this.amtRetrieved = amtRetrieved;
	}
	public int calculate(int quan) {//implemented for calculate should probably be void and change the text file directly
		quan = quan- amtRetrieved;
		return quan;
	}
	public String receive() {
		String s = "Item received: " + getItemReceived()+"\n" + "Amount: " + getamtRetrieved() + "\n";
		return s;
	}
	
    
    public String getItemReceived() {
        return itemReceived.get();
    }

    public void setItemRecceived(String itemReceived) {
        this.itemReceived = new SimpleStringProperty(itemReceived);
    }

    public int getamtRetrieved() {
        return amtRetrieved;
    }

    public void setamtRetrieved(int amtRetrieved) {
        this.amtRetrieved = amtRetrieved;
    }

}

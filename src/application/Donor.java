package application;

import javafx.beans.property.SimpleStringProperty;

public class Donor extends User { //viewing class
	
	
	private SimpleStringProperty itemType, itemName;
    //private String currentuser;
	private int quantity,hold;
	
	Donor(String type, String currentuser,String itemType,String itemName,int quantity) {
		super(currentuser,type);
		this.itemType = new SimpleStringProperty(itemType);
		this.itemName = new SimpleStringProperty(itemName);
		this.quantity = quantity ; //new SimpleStringProperty(quantity);
	}
	 
	public String notification() {
		String s = "Item name: " + getItemName()+"\n" + "Quantity: " + getQuantity() + "\n";
		
		return s;
	}

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getItemType() {
        return itemType.get();
    }

    public void setItemType(String itemType) {
        this.itemType = new SimpleStringProperty(itemType);
    }
    public int getQuantity() {
        return quantity;//.get();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; //new SimpleStringProperty(quantity);
    }

 
}
